package com.example.yina.model


data class News(
    val heading: String,
    val desc: String,
    val imgUrl: String?,
    val uploadedAt: String? = "12th Jan, 04:30 PM",
)

