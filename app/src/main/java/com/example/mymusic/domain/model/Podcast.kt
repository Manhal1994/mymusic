package com.example.mymusic.domain.model

data class Podcast(
    val available: Boolean,
    val description: String,
    val fans: Int,
    val id: Int,
    val link: String,
    val picture: String,
    val picture_big: String,
    val picture_medium: String,
    val picture_small: String,
    val picture_xl: String,
    val share: String,
    val title: String,
    val type: String
)