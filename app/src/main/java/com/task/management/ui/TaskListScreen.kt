package com.task.management.ui

import android.annotation.SuppressLint
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.task.management.Routes
import com.task.management.models.TaskUi

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskListScreen(navigation: NavController, tasks: List<TaskUi>) {

    Scaffold(
        topBar = {},
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navigation.navigate(Routes.TASK_SCREEN) }
            ) {
                Icon(Icons.Filled.Add, "Floating action button.")
            }
        },

        ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),

            ) {
            val scrollState = rememberLazyListState()

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                state = scrollState
            ) {
                items(tasks) {

                    TaskListItem(
                        item = it,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Divider(color = Color.Black, thickness = 1.dp)
                }
            }


        }
    }
}


@Composable
private fun TaskListItem(
    item: TaskUi,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(text = item.date)
        Text(
            text = item.title,
            fontWeight = FontWeight.Bold,
        )
        Text(text = item.description)
        Text(text = item.status)
    }
}