package com.vb.todo.ui.screens.list

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vb.todo.R
import com.vb.todo.components.PriorityItem
import com.vb.todo.data.models.Priority
import com.vb.todo.ui.theme.topAppBarBackgroundColor
import com.vb.todo.ui.theme.topAppBarContentColor


@Composable
fun ListAppBar() {
    DefaultListAppBar(onSearchBarClicked = {}, onSortClicked = {})
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultListAppBar(onSearchBarClicked: () -> Unit, onSortClicked: (Priority) -> Unit) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.topAppBarBackgroundColor,
            titleContentColor = MaterialTheme.colorScheme.topAppBarContentColor
        ),
        title = {
            Text(
                modifier = Modifier.padding(start = 10.dp),
                text = "Tasks",
                color = MaterialTheme.colorScheme.topAppBarContentColor
            )
        },
        actions = {
            SearchAction(onSearchBarClicked)
            SortAction(onSortClicked)
        }
    )
}

@Composable
fun SearchAction(onSearchBarClicked: () -> Unit) {
    IconButton(onClick = onSearchBarClicked) {
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = stringResource(id = R.string.search_tasks),
            tint = Color.White
        )
    }
}

@Composable
fun SortAction(onSortClicked: (Priority) -> Unit) {
    var expaned by remember {
        mutableStateOf(false)
    }
    IconButton(onClick = { /*TODO*/ }) {
        Icon(
            painter = painterResource(id = R.drawable.ic_filter),
            contentDescription = "Filter",
            tint = Color.White
        )
    }
    DropdownMenu(expanded = expaned, onDismissRequest = { expaned = false }) {
        DropdownMenuItem(
            text = { PriorityItem(priority = Priority.LOW) },
            onClick = {
                expaned = false
                onSortClicked(Priority.LOW)
            })
        DropdownMenuItem(
            text = { PriorityItem(priority = Priority.HIGH) },
            onClick = {
                expaned = false
                onSortClicked(Priority.HIGH)
            })
        DropdownMenuItem(
            text = { PriorityItem(priority = Priority.NONE) },
            onClick = {
                expaned = false
                onSortClicked(Priority.NONE)
            })
    }

}

@Preview
@Composable
fun TopAppBarPreview() {
    DefaultListAppBar(onSearchBarClicked = {}, onSortClicked = {})
}