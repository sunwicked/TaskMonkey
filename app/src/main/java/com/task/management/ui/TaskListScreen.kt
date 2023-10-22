package com.task.management.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.task.management.Routes
import com.task.management.models.Task

@Composable
fun TaskListScreen(navigation: NavController, tasks: List<Task>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),

    ) {
        val scrollState = rememberLazyListState()
        Text("Second screen")
        Button(onClick = {
            navigation.navigate(Routes.TASK_SCREEN)
        }) {
            Text(text = "Create Task")
        }
                     LazyColumn(modifier = Modifier.fillMaxSize() ,
                state = scrollState) {
                items(tasks) {

                        TaskListItem(
                            item = it,
                            modifier = Modifier.fillMaxWidth()
                        )

                }
            }

    }
}


@Composable
private fun TaskListItem(
    item: Task,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(text = item.id)
        Text(
            text = item.title,
            fontWeight = FontWeight.Bold,
        )
        Text(text = item.description)
        Text(text = item.status.toString())
    }
}