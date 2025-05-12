package com.example.composehiltexample.main

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composehiltexample.manager.IndicatorManager
import com.example.composehiltexample.model.User
import com.example.composehiltexample.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: UserRepository,
    private val indicatorManager: IndicatorManager
): ViewModel() {
    var users by mutableStateOf<List<User>>(emptyList())
        private set

    fun getAllUsers() {
        viewModelScope.launch {
            indicatorManager.show()
            try {
                val response = repository.getAllUsers()
                users = response.users
                Log.d("MainViewModel", "getAllUser: ${users}")
            } catch (e: Exception) {
                Log.e("MainViewModel", "getAllUser Error: ${ e.message }")
            } finally {
                indicatorManager.hide()
            }
        }
    }

}