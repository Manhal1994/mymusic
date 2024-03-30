package com.example.mymusic.data.remote.dto

data class PlaylistsDto(
    val `data`: List<PlaylistDto>,
    val total: Int
)