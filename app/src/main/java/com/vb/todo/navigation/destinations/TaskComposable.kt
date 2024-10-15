package com.vb.todo.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.vb.todo.ui.screens.list.ListScreen
import com.vb.todo.util.Action
import com.vb.todo.util.Constants.LIST_ARGUMENT_KEY
import com.vb.todo.util.Constants.LIST_SCREEN
import com.vb.todo.util.Constants.TASK_SCREEN


fun NavGraphBuilder.taskComposable(
    navigateToListScreen: (Action) -> Unit
) {
    composable(
        route = TASK_SCREEN,
        arguments = listOf(navArgument(LIST_ARGUMENT_KEY) {
            type = NavType.IntType
        })
    ) {

    }
}