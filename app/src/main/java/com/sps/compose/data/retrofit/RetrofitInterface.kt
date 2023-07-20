package com.sps.compose.data.retrofit

import com.sps.compose.data.retrofit.dto.ApiResponseDto
import okhttp3.ResponseBody
import retrofit2.http.*

interface RetrofitInterface {
    @FormUrlEncoded
    @POST("login")
    suspend fun authenticate(
        @Field("username") phone: String,
        @Field("password") password: String,
    ): ApiResponseDto

    @FormUrlEncoded
    @POST("register")
    suspend fun signup(
        @Field("name") name: String,
        @Field("phone") phone: String,
        @Field("email") email: String,
        @Field("password") password: String,
    ): ApiResponseDto

    @POST("test")
    suspend fun test(): ResponseBody
}