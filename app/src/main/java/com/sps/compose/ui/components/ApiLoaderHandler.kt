package com.sps.compose.ui.components

import androidx.compose.runtime.Composable
import com.sps.compose.Config
import com.sps.compose.util.Resource
import com.sps.compose.util.Status
import com.sps.compose.ui.components.dialogs.Alert
import com.sps.compose.ui.components.dialogs.AlertType

@Composable
fun ApiLoaderHandler(res: Resource<Any>?, success: String = "") {
    when (res?.status) {
        Status.LOADING -> {
            Config.processing.value = true
        }
        Status.SUCCESS -> {
            Config.processing.value = false
            if (success.isNotEmpty()) {
                Alert(title = "Success", content = success, alertType = AlertType.SUCCESS)
            }
        }
        Status.ERROR -> {
            Config.processing.value = false
            Alert(title = "Error", content = "${res.message}", alertType = AlertType.ERROR)
        }
        else -> Unit
    }
}