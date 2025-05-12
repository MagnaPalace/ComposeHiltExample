package com.example.composehiltexample.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composehiltexample.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: UserRepository
): ViewModel() {

    fun getAllUsers() {
        viewModelScope.launch {
            try {
                val response = repository.getAllUsers()
                Log.d("MainViewModel", "getAllUser: ${response.users}")
            } catch (e: Exception) {
                Log.e("MainViewModel", "getAllUser Error: ${ e.message }")
            }
        }
    }

}