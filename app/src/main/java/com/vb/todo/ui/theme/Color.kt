package com.vb.todo.ui.theme


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.luminance

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)


val LightGray = Color(0xFFFCFCFCF)
val MediumGray = Color(0xFF9C9C9C9)
val DarkGray = Color(0xFF141414)


val LowPriorityColor = Color(0xFF00C980)
val HighPriorityColor = Color(0xFFFF4646)
val NonePriorityColor = Color(0xFFFFFFFF)
val MediumPriorityColor = Color(0xFFFFC114)


val Color.topAppBarcontentColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) {
        Color.White
    } else {
        LightGray
    }
