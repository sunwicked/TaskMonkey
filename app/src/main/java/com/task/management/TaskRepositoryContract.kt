package com.task.management

import com.task.management.models.Task

interface TaskRepositoryContract {

   suspend fun getTasks():List<Task>

  suspend  fun updateTasks(task: Task)
}
