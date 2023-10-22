package com.task.management.models

data class Task(val title:String, val description:String, val status:Status, val id:String)



sealed class Status{
    object ToDo:Status()
    object InProgress:Status()
    object Done:Status()
}
