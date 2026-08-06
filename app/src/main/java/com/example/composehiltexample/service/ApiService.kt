package com.example.composehiltexample.service

import com.example.composehiltexample.local.UserResponse
import com.example.composehiltexample.model.User
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("api/user/all") // GET
    suspend fun getAllUsers(): UserResponse

    @POST("api/user/store")
    suspend fun storeUser(@Body user: User): User

}