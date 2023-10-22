package com.task.management.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.task.management.Routes

@Composable
fun TaskScreen(navigation: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
             horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Task")
        Button(onClick = {
            navigation.navigate(Routes.TASK_LIST_SCREEN)
        }) {
            Text("Go to second screen")
        }
    }
}
