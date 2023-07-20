package com.sps.compose.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Error
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.sps.compose.ui.theme.successMain
import com.sps.compose.util.Resource
import com.sps.compose.util.Status

@Composable
fun ResultNote(loginEvents: Resource<Any>?) {
    if (loginEvents?.status == Status.ERROR) {
        ResultUiContainer(
            message = loginEvents.message,
            containerColor = MaterialTheme.colorScheme.errorContainer,
            icon = Icons.Default.Error
        )
    } else if (loginEvents?.status == Status.SUCCESS) {
        ResultUiContainer(
            message = "Success",
            containerColor = successMain,
            icon = Icons.Default.Check
        )
    }
}

@Composable
fun ResultUiContainer(message: String?, containerColor: Color, icon: ImageVector) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = CardDefaults.cardColors(containerColor = containerColor)
    ) {
        Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = icon,
                contentDescription = "",
                modifier = Modifier.padding(end = 8.dp)
            )
            Text(
                text = message ?: "",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
