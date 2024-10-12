package com.vb.todo.ui.screens.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun ListScreen(
    navigateToTaskScreen: (Int) -> Unit
) {

    Scaffold(
        topBar = { ListAppBar() },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
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
fun ListFab(onFabclicked: (Int) -> Unit) {
    FloatingActionButton(onClick = {
        onFabclicked(-1)
    }) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "",
            tint = Color.Black
        )
    }
}

@Preview
@Composable
fun ListScreenPreview() {
    ListScreen(navigateToTaskScreen = {})
}