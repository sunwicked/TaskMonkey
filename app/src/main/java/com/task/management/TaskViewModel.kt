package com.task.management

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.task.management.di.Injector
import com.task.management.repository.Status.InProgress.getValue
import com.task.management.repository.Task
import com.task.management.models.TaskUi
import com.task.management.repository.TaskRepository
import com.task.management.ui.Chip
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date

class TaskViewModel(private val taskRepository: TaskRepository) : ViewModel() {


    private val _tasks =
        MutableStateFlow<List<TaskUi>>(emptyList())

    val tasks = _tasks.asStateFlow()


    init {
        getTasks()
    }

    fun updateTasks(task: Task) {
        viewModelScope.launch {
            taskRepository.updateTasks(task)
            getTasks()
        }
    }


    private fun getTasks() {
        viewModelScope.launch {
            _tasks.value = taskRepository.getTasks().convert()
        }

    }

    fun filterChip(chip: Chip) {
        getTasks()
       val filteredList =  tasks.value.filter {
            it.status == chip.text
        }
        _tasks.value = filteredList
    }

    companion object {

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T =
                Injector.createTaskViewModel() as T
        }

    }

}


private fun List<Task>.convert(): List<TaskUi> {
  return  this.map {

        TaskUi(
            it.title,
            it.description,
            it.status.getValue(),
            it.id.convertToDate()
        )

    }
}

@SuppressLint("SimpleDateFormat")
private fun String.convertToDate(): String {

    val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
    val date = Date(this.toLong())
    return dateFormat.format(date)

}

