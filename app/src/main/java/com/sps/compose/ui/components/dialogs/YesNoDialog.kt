package com.sps.time_tracker_ssu.ui.components.dialogs

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun YesNoDialog(
    showDialog: MutableState<Boolean> = mutableStateOf(false),
    title: String,
    content: String,
    confirmText: String,
    onConfirm:() ->Unit
) {
    if (showDialog.value) {
        Dialog(onDismissRequest = { showDialog.value = false }) {
            AlertDialog(
                onDismissRequest = { showDialog.value = false },
                dismissButton = {
                    TextButton(onClick = { showDialog.value = false }) {
                        Text(text = "No")
                    }
                },
                properties = DialogProperties(),
                title = { Text(text = title) },
                text = {
                    Text(
                        text = content,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                },
                icon = {
                    Icon(
                        imageVector = Icons.Default.QrCode,
                        contentDescription = "",
                        modifier = Modifier.size(40.dp)
                    )
                },
                confirmButton = {
                    TextButton(onClick = {
                        showDialog.value = false
                        onConfirm()
                    }) {
                        Text(text = confirmText)
                    }
                }
            )
        }
    }

}