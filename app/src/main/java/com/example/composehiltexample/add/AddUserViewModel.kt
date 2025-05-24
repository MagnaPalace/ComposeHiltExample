package com.example.composehiltexample.add

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
class AddUserViewModel @Inject constructor(
    private val repository: UserRepository,
    private val indicatorManager: IndicatorManager
): ViewModel() {

    var isSaved by mutableStateOf(false)
        private set

    fun addUser(userId: String, name: String, comment: String) {
        val newUser = User(userId, name, comment)
        viewModelScope.launch {
            indicatorManager.show()
            try {
                val user = repository.addUser(newUser)
                Log.d("AddUserViewModel", "addUser: $user")
                user.let {
                    isSaved = true
                }
            } catch (e: Exception) {
                Log.e("AddUserViewModel", "addUser Error: ${ e.message }")
            } finally {
                indicatorManager.hide()
            }
        }
    }
}