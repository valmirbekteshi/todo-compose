package com.vb.todo.ui.screens.list

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.android.material.color.MaterialColors


@Composable
fun ListAppBar() {
    DefaultListAppBar()
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultListAppBar() {
    TopAppBar(
        navigationIcon = {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "" )
        },
        colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.primaryContainer),
        title = {
            Text(modifier = Modifier.padding(start = 10.dp), text = "Tasks", color = if(isSystemInDarkTheme()) Color.White else Color.DarkGray)
        },
        actions = {
            Icon(imageVector = Icons.Default.List, contentDescription = "" )
        }
    )
}


@Preview
@Composable
fun TopAppBarPreview() {
    DefaultListAppBar()
}