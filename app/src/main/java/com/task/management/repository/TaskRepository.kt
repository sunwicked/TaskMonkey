package com.task.management.repository


object TaskRepository: TaskRepositoryContract {

    private val tasks =  mutableListOf<Task>()


    override suspend fun getTasks() = tasks.toList()

    override suspend fun updateTasks(task: Task){
        tasks.add(task)
    }

    override suspend fun delete(id: String) {
        tasks.removeIf {  it.id == id }
    }

    override suspend fun updateStatus(id: String, status: Status) {
        val task = tasks.find { it.id == id }
        val updateTask = task?.copy(status = status)

        if (updateTask != null) {
            val pos = tasks.indexOfFirst { it.id == id }
            tasks.remove(task)
            tasks.add(pos, updateTask)
        }
    }


}
