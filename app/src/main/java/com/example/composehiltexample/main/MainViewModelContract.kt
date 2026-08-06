package com.example.composehiltexample.main

import com.example.composehiltexample.model.User
import kotlinx.coroutines.flow.StateFlow

// MainScreenから呼び出すものを全部定義する
interface MainViewModelContract {

    val users: StateFlow<List<User>>

    fun getAllUsers()
}