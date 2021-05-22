package com.example.jinsool.response

data class ResponsePlayerData(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: PlayerData?
)

data class PlayerData(
    val player: Int,
    val question: List<PlayerItem>?
)

data class PlayerItem(
    val _id: String,
    val title: String,
    val level: Int
)
