package com.vb.todo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.vb.todo.navigation.destinations.listComposable
import com.vb.todo.navigation.destinations.taskComposable
import com.vb.todo.util.Constants.LIST_SCREEN

@Composable
fun SetupNavigation(navController: NavHostController) {

    val screen = remember(navController) {
        Screens(navHostController = navController)
    }

    NavHost(
        navController = navController,
        startDestination = LIST_SCREEN
    )
    {
        listComposable(
            navigateToTaskScreen = screen.task
        )

        taskComposable(
            navigateToListScreen = screen.list
        )

    }

}