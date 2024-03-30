package com.example.mymusic.data.remote.dto

data class UserDto(
    val id: Long,
    val name: String,
    val tracklist: String,
    val type: String
)