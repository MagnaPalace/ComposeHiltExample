package com.example.composehiltexample.add

interface AddUserViewModelContract {

    val isSaved: Boolean

    fun addUser(userId: String, name: String, comment: String)

}