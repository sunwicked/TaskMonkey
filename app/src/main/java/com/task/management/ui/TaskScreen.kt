package com.task.management.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.task.management.Routes
import com.task.management.models.Status
import com.task.management.models.Task

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskScreen(navigation: NavController, onTaskCreated: (task: Task) -> Unit) {

    var title by remember {
        mutableStateOf("")
    }
    var description by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Text("Task")

        OutlinedTextField(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            value = title,
            onValueChange = { title = it },
            label = { Text("Title") })

        OutlinedTextField(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.3f),
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") })

        Button(
            modifier = Modifier.padding(horizontal = 4.dp),
            onClick = {
                onTaskCreated(
                    Task(
                        title,
                        description,
                        Status.ToDo,
                        System.currentTimeMillis().toString()
                    )
                )
                navigation.navigate(Routes.TASK_LIST_SCREEN)
            }) {
            Text("Create Task")
        }
    }
}
