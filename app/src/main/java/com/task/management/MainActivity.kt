package com.task.management

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.task.management.navigation.Routes
import com.task.management.ui.TaskScreen
import com.task.management.ui.TaskListScreen
import com.task.management.ui.theme.TaskManagementTheme

class MainActivity : ComponentActivity() {


    private val viewModel by viewModels<TaskViewModel> { TaskViewModel.Factory }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            TaskManagementTheme {
                val navController = rememberNavController()
                // A surface container using the 'background' color from the theme
                NavHost(navController = navController, startDestination = Routes.TASK_SCREEN) {
                    composable(Routes.TASK_SCREEN) {
                        TaskScreen(navigation = navController,
                            onTaskCreated = {
                                viewModel.updateTasks(it)
                            }
                        )
                    }
                    composable(Routes.TASK_LIST_SCREEN) {
                        TaskListScreen(
                            navigation = navController,
                            tasks = viewModel.tasks.collectAsState().value
                        )
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