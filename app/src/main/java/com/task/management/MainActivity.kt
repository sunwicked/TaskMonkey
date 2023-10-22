package com.task.management

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.task.management.ui.TaskScreen
import com.task.management.ui.TaskListScreen
import com.task.management.ui.theme.TaskManagementTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskManagementTheme {
                val navController = rememberNavController()
                // A surface container using the 'background' color from the theme
                NavHost(navController = navController, startDestination = Routes.TASK_LIST_SCREEN) {
                    composable( Routes.TASK_SCREEN) {
                        TaskScreen(navigation = navController)
                    }
                    composable( Routes.TASK_LIST_SCREEN) {
                        TaskListScreen(navigation = navController)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TaskManagementTheme {
        Greeting("Android")
    }
}