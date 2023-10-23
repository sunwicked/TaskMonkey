package com.task.management.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ElevatedFilterChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChipList(highlightColor: Color = Color(0xFF009688) , itemsList: List<Chip>,
             onChipListUpdated:(chip:Chip)-> Unit) {

    LocalContext.current.applicationContext

    var selectedItem by remember {
        mutableStateOf(itemsList[0]) // initially, first item is selected
    }

    LazyRow(modifier = Modifier.fillMaxWidth()) {
        items(itemsList) { item ->
            ElevatedFilterChip(
                modifier = Modifier.padding(all = 6.dp), // gap between items
                selected = (item == selectedItem),
                onClick = {
                    selectedItem = item
                    onChipListUpdated(item)
                },
                label = {
                   Text(text = item.text,
                       fontWeight =  if (item == selectedItem) FontWeight.Medium else FontWeight.Normal
                       )
                },
                leadingIcon = if (item == selectedItem) {
                    {
                        Icon(
                            imageVector = Icons.Default.Done,
                            contentDescription = null,
                            modifier = Modifier.size(
                                FilterChipDefaults.IconSize
                            )
                        )
                    }
                } else {
                    null
                },
                colors = FilterChipDefaults.elevatedFilterChipColors(
                    labelColor = highlightColor,
                    selectedLabelColor = highlightColor,
                    selectedLeadingIconColor = highlightColor
                    //selectedContainerColor = highlightColor.copy(alpha = 0.1f)
                ),
                elevation = FilterChipDefaults.elevatedFilterChipElevation(

                ),
                border = null
            )
        }
    }
}