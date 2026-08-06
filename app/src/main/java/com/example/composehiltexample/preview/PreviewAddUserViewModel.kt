package com.example.composehiltexample.preview

import com.example.composehiltexample.add.AddUserViewModelContract

class PreviewAddUserViewModel: AddUserViewModelContract {

    override var isSaved: Boolean = false

    override fun addUser(userId: String, name: String, comment: String) {
        // 何もしない
    }
}