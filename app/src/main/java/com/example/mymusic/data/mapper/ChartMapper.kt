package com.example.mymusic.data.mapper

import com.example.mymusic.data.remote.dto.ChartDto
import com.example.mymusic.domain.model.Chart

/**
 * Created by ManhalKhwashki on 3/20/2024.
 */

fun ChartDto.toChart(): Chart {
    return Chart(tracks = tracks.toTracks(), albums = albums.toAlbums(), artists = artists.toArtists(), playlists = playlists.toPlaylists(), podcasts = podcasts.toPodcasts())
}