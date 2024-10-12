package com.vb.todo.navigation

import androidx.navigation.NavHostController
import com.vb.todo.util.Action
import com.vb.todo.util.Constants.LIST_SCREEN

class Screens(navHostController: NavHostController) {

    val task: (Int) -> Unit = { taskId ->
        navHostController.navigate(route = "task/$taskId")
    }

    val list: (Action) -> Unit = { action ->
        navHostController.navigate(route = "list/${action}") {
            popUpTo(LIST_SCREEN) { inclusive = true }
        }
    }
}