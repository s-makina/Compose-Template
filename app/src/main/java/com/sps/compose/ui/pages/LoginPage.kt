package com.sps.compose.ui.pages

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sps.compose.samplecomponent.SampleComponent

@Composable
fun LoginPage() {
    Scaffold() { paddingValues ->
        Box(modifier = Modifier.fillMaxSize()) {

            Column(modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)) {

            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    LoginPage()
}