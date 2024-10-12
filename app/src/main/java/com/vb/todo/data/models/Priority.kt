package com.vb.todo.data.models

import androidx.compose.ui.graphics.Color
import com.vb.todo.ui.theme.HighPriorityColor
import com.vb.todo.ui.theme.LowPriorityColor
import com.vb.todo.ui.theme.MediumPriorityColor
import com.vb.todo.ui.theme.NonePriorityColor

enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}