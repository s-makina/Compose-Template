package com.sps.compose.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.sps.compose.samplecomponent.SampleComponent
import com.sps.compose.ui.viewmodel.TestViewModel

@Composable
fun TestPage() {
    val testViewModel: TestViewModel = hiltViewModel()

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {


//        Button(onClick = { testViewModel.loadData() }) {
//            Text(text = "Test")
//        }
    }
}