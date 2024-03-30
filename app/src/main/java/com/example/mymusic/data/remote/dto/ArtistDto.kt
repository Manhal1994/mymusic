package com.example.mymusic.data.remote.dto

data class ArtistDto(
    val id: Long,
    val link: String,
    val name: String,
    val picture: String,
    val picture_big: String,
    val picture_medium: String,
    val picture_small: String,
    val picture_xl: String,
    val position: Int,
    val radio: Boolean,
    val tracklist: String,
    val type: String
)