package com.task.management

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.task.management.di.Injector
import com.task.management.models.Task
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TaskViewModel(private val taskRepository: TaskRepository) : ViewModel() {


    private val _tasks =
        MutableStateFlow<List<Task>>(emptyList())

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
            _tasks.value = taskRepository.getTasks()
        }

    }

    companion object {

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T =
                Injector.createTaskViewModel() as T
        }

    }

}