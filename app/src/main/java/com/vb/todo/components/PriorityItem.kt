package com.vb.todo.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.vb.todo.data.models.Priority
import com.vb.todo.ui.theme.LARGE_PADDING
import com.vb.todo.ui.theme.PRIORITY_INDICATOR_SIZE
import com.vb.todo.ui.theme.Typography

@Composable
fun PriorityItem(priority: Priority) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Canvas(modifier = Modifier.size(PRIORITY_INDICATOR_SIZE)) {
            drawCircle(color = priority.color)
        }
        Text(
            modifier = Modifier.padding(start = LARGE_PADDING),
            text = priority.name,
            style = Typography.headlineMedium,
            color = MaterialTheme.colorScheme.surface
        )
    }
}

@Preview
@Composable
fun PreviewPriorityItem() {
    PriorityItem(priority = Priority.HIGH)
}