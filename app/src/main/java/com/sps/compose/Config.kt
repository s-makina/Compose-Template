package com.sps.compose

import androidx.compose.runtime.mutableStateOf

object Config {
//    const val API_ADDRESS = "http://10.0.3.70:81/api/"/
//    const val API_ADDRESS = "https://staffattendance.maryqueenofpeace.africa/api/"
    const val API_ADDRESS = "http://100.24.76.128:83/api/"
//    const val API_ADDRESS = "http://10.0.3.57:83/api/"
//    const val API_ADDRESS = "http://10.0.3.132:89/api/"
    const val API_KEY = ""
    val processing = mutableStateOf(false)
}