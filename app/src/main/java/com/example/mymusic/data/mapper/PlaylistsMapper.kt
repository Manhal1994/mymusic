package com.example.mymusic.data.mapper

import com.example.mymusic.data.remote.dto.PlaylistDto
import com.example.mymusic.data.remote.dto.PlaylistsDto
import com.example.mymusic.data.remote.dto.TrackDto
import com.example.mymusic.domain.model.Playlist
import com.example.mymusic.domain.model.Playlists

/**
 * Created by ManhalKhwashki on 3/17/2024.
 */

fun PlaylistsDto.toPlaylists(): Playlists{
    return Playlists(data = data.map { it.toPlaylist() },total = total)
}

fun PlaylistDto.toPlaylist(): Playlist{
    return Playlist(checksum, creation_date, id, link, md5_image, nb_tracks, picture, picture_big, picture_medium, picture_small, picture_type, picture_xl, public, title, tracklist, type, user.toUser())
}