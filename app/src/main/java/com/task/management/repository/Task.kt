package com.task.management.repository

data class Task(val title:String, val description:String, val status: Status, val id:String)



sealed class Status(private val value: String ){
    object ToDo: Status("To Do")
    object InProgress: Status("In Progress")
    object Done: Status("Done")

    fun Status.getValue(): String {
        return this.value
    }
}
