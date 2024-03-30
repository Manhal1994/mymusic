package com.example.mymusic.data.remote.dto

data class ChartDto(
    val albums: AlbumsDto,
    val artists: ArtistsDto,
    val playlists: PlaylistsDto,
    val podcasts: PodcastsDto,
    val tracks: TracksDto
)