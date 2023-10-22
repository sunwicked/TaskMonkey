package com.task.management.repository

interface TaskRepositoryContract {

   suspend fun getTasks():List<Task>

  suspend  fun updateTasks(task: Task)
}
