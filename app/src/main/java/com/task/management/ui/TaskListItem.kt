package com.task.management.ui

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.task.management.models.TaskUi

@Composable
fun TaskListItem(
    item: TaskUi,
    modifier: Modifier = Modifier,
    onDelete: (id: String) -> Unit,
    onUpdateStatus: (id: String, status:String) -> Unit,
) {

    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(item.status) }

    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = item.date)
            Text(
                text = item.status,
                fontWeight = FontWeight.Bold
            )
        }

        Text(
            text = item.title,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = item.description,
            fontSize = 20.sp
        )

        Row(
            modifier = Modifier.fillMaxWidth()
        )  {


            Row(

                modifier = Modifier.weight(1F)
                    .height(48.dp)
                    .background(color = Color.Cyan)
                    .padding(2.dp)
                    .clickable { expanded = !expanded }
                ,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            )   {
                Text(text = selectedText)
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier.fillMaxWidth(fraction = 0.5f)

                ) {
                    DropdownMenuItem(
                        text = { Text("To Do") },
                        onClick = { selectedText = "To Do"
                            onUpdateStatus(item.id,selectedText)}
                    )
                    DropdownMenuItem(
                        text = { Text("In Progress") },
                        onClick = { selectedText = "In Progress"
                            onUpdateStatus(item.id,selectedText)}
                    )
                    DropdownMenuItem(
                        text = { Text("Done") },
                        onClick = { selectedText = "Done"
                            onUpdateStatus(item.id,selectedText) }
                    )

                }
            }

            Row(

                modifier = Modifier
                    .weight(1F)
                    .height(48.dp)
                    .background(color = Color.Red)
                    .padding(2.dp)
                ,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                Image(
                    painter = painterResource(id = android.R.drawable.ic_menu_delete),
                    contentDescription = "Delete",
                    modifier = Modifier
                        .size(40.dp)
                        .clickable { onDelete(item.id) }
                )
            }
        }

    }
}