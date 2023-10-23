package com.task.management.repository

interface TaskRepositoryContract {

    suspend fun getTasks(): List<Task>

    suspend fun updateTasks(task: Task)
    suspend fun delete(id: String)
    suspend fun updateStatus(id: String, status: Status)
}
