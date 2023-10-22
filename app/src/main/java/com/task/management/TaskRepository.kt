package com.task.management

import com.task.management.models.Task


object TaskRepository:TaskRepositoryContract {

    private val tasks =  mutableListOf<Task>()


    override suspend fun getTasks() = tasks.toList()

    override suspend fun updateTasks(task: Task){
        tasks.add(task)
    }

}
