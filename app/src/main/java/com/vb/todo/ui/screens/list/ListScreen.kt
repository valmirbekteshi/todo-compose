package com.vb.todo.ui.screens.list

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vb.todo.data.models.Priority
import com.vb.todo.data.models.TodoTask
import com.vb.todo.util.Action
import kotlin.random.Random


@Composable
fun ListScreen(
    navigateToTaskScreen: (Int) -> Unit
) {

    Scaffold(
        topBar = { ListAppBar() },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(padding)
            ) {

            }
        },
        floatingActionButton = {
            ListFab(onFabclicked = navigateToTaskScreen)
        }
    )
}

@Composable
fun ListItem(itemText: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.DarkGray)
    ) {
        Text(
            text = itemText,
            color = if (isSystemInDarkTheme()) Color.White else Color.LightGray,
            modifier = Modifier
                .clickable { onItemClicked(itemText) } // Combine clickable
                .padding(16.dp), // Combine padding
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

fun onItemClicked(itemText: String) {
    Log.d("TAG", "onItemClicked: $itemText ")
}

@Composable
fun ListFab(onFabclicked: (taskId:Int) -> Unit) {
    FloatingActionButton(onClick = {
        onFabclicked(-1)
    }) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "",
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}

@Preview
@Composable
fun ListScreenPreview() {
    ListScreen(navigateToTaskScreen = {})
}