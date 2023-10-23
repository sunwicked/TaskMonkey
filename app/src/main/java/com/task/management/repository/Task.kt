package com.task.management.repository

import com.task.management.ui.Chip

data class Task(val title:String, val description:String, val status: Status, val id:String)



sealed class Status(private val value: String ){
    object ToDo: Status("To Do")
    object InProgress: Status("In Progress")
    object Done: Status("Done")

    fun Status.getValue(): String {
        return this.value
    }

    fun getChips(): List<Chip> {
        return listOf(Chip("To Do",false),
            Chip("In Progress",false),
            Chip("Done",false))
    }
}
