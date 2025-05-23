package com.example.composehiltexample.repository

import com.example.composehiltexample.local.UserResponse
import com.example.composehiltexample.model.User
import com.example.composehiltexample.service.ApiService
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getAllUsers(): UserResponse {
        return apiService.getAllUsers()
    }

    suspend fun addUser(user: User): User {
        return apiService.storeUser(user)
    }
}