package com.sps.compose.data.repo

import com.sps.compose.data.retrofit.RetrofitInterface
import com.sps.compose.util.log

class TestRepo(val retrofitInterface: RetrofitInterface) {
    suspend fun testApi() {
        try {
            retrofitInterface.test()
        } catch (e: Exception) {
            log(e.message)
        }
    }

}