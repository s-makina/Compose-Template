package com.sps.compose.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sps.compose.data.repo.TestRepo
import com.sps.compose.util.log
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class TestViewModel @Inject constructor(
    private val testRepo: TestRepo
): ViewModel() {
    fun loadData() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val res = testRepo.testApi()
                log(res)
            } catch (e: Exception) {
                log(e.message)
            }

        }
    }
}