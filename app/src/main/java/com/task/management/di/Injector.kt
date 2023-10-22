package com.task.management.di

import com.task.management.TaskRepository
import com.task.management.TaskViewModel

object Injector {



    private val taskRepository: TaskRepository = TaskRepository

    fun createTaskViewModel() = TaskViewModel(taskRepository)

}