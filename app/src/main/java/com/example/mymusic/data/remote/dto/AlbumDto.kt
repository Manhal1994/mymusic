package com.example.mymusic.data.remote.dto

data class AlbumDto(
    val cover: String?,
    val cover_big: String?,
    val cover_medium: String?,
    val cover_small: String?,
    val cover_xl: String?,
    val id: Long,
    val md5_image: String?,
    val title: String,
    val tracklist: String?,
    val type: String?
)