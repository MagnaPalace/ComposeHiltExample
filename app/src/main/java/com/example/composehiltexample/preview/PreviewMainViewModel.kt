package com.example.composehiltexample.preview

import com.example.composehiltexample.main.MainViewModelContract
import com.example.composehiltexample.model.User
import kotlinx.coroutines.flow.MutableStateFlow

class PreviewMainViewModel : MainViewModelContract {

    override val users = MutableStateFlow(
        listOf(
            User(
                id = "1",
                name = "Preview User",
                comment = "Comment!"
            )
        )
    )

    override fun getAllUsers() {
        // 何もしない
    }
}