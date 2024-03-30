package com.example.mymusic.domain.model

data class Chart(
    val albums: Albums? = null,
    val artists: Artists,
    val playlists: Playlists? = null,
    val podcasts: Podcasts? = null,
    val tracks: Tracks
)