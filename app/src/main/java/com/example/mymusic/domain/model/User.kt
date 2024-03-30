package com.example.mymusic.domain.model

data class User(
    val id: Long,
    val name: String,
    val tracklist: String,
    val type: String
)