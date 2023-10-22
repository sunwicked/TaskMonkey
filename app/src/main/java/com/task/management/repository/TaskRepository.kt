package com.task.management.repository


object TaskRepository: TaskRepositoryContract {

    private val tasks =  mutableListOf<Task>()


    override suspend fun getTasks() = tasks.toList()

    override suspend fun updateTasks(task: Task){
        tasks.add(task)
    }

}
