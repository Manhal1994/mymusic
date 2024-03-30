package com.example.mymusic.data.remote.dto

data class AlbumsDto(
    val `data`: List<AlbumDto>,
    val total: Int
)