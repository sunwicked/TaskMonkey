package com.task.management.repository

import com.task.management.ui.Chip

data class Task(val title:String, val description:String, val status: Status, val id:String)


private const val TO_DO = "To Do"

private const val IN_PROGRESS = "In Progress"

private const val DONE = "Done"

sealed class Status(private val value: String ){
    object ToDo: Status(TO_DO)
    object InProgress: Status(IN_PROGRESS)
    object Done: Status(DONE)

    fun Status.getValue(): String {
        return this.value
    }

   fun ofValue(status: String): Status {
        return when(status)
        {
            IN_PROGRESS ->{
                InProgress
            }
            DONE ->{
                Done
            }

            else -> {ToDo}
        }
    }

    fun getChips(): List<Chip> {
        return listOf(Chip(TO_DO,false),
            Chip(IN_PROGRESS,false),
            Chip(DONE,false))
    }
}
