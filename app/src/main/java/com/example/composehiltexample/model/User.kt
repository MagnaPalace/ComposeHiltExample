package com.example.composehiltexample.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class User(
    @Json(name = "user_id") val id: String,
    val name: String,
    val comment: String
)
