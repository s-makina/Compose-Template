package com.sps.compose.data

import androidx.compose.runtime.mutableStateOf
import com.sps.compose.data.model.User

object Prefs {
    val authUser = mutableStateOf<User?>(null)
}