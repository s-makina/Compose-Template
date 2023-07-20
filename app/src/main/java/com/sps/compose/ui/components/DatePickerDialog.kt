package com.sps.compose.ui.components

import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import java.util.Calendar
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerComponent(showDatePicker: MutableState<Boolean>, onSet: (Long?) -> Unit = {}) {
    // Fetching the Local Context
    val mContext = LocalContext.current

    // Declaring integer values
    // for year, month and day
    val mYear: Int
    val mMonth: Int
    val mDay: Int

    // Initializing a Calendar
//
//    // Fetching current year, month and day
//    mYear = mCalendar.get(Calendar.YEAR)
//    mMonth = mCalendar.get(Calendar.MONTH)
//    mDay = mCalendar.get(Calendar.DAY_OF_MONTH)

    val mCalendar = Calendar.getInstance()
    mCalendar.time = Date()
    mYear = mCalendar.get(Calendar.YEAR)

    val state = rememberDatePickerState(
        initialSelectedDateMillis = mCalendar.timeInMillis,
        yearRange = IntRange(2022, mYear)
    )

    if (showDatePicker.value) {
        DatePickerDialog(
            onDismissRequest = { showDatePicker.value = false },
            dismissButton = {
                TextButton(onClick = { showDatePicker.value = false }) {
                    Text(text = "Cancel")
                }
            },
            confirmButton = {
                TextButton(onClick = {
                    onSet(state.selectedDateMillis)
                    showDatePicker.value = false
                }) {
                    Text(text = "Set")
                }
            }
        ) {
            DatePicker(state = state)
        }
    }
}