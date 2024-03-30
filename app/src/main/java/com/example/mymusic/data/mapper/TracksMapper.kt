package com.example.mymusic.data.mapper

import com.example.mymusic.data.local.entities.TrackEntity
import com.example.mymusic.data.remote.dto.TrackDto
import com.example.mymusic.data.remote.dto.TracksDto
import com.example.mymusic.domain.model.*

/**
 * Created by ManhalKhwashki on 3/20/2024.
 */

fun TracksDto.toTracks(): Tracks {
    return Tracks(data = data.map { it.toTrack() }, total = total);
}

fun TrackDto.toTrack(): Track {
    return Track(
        album = album.toAlbum(),
        artist.toArtists(),
        duration,
        explicit_content_cover,
        explicit_content_lyrics,
        explicit_lyrics,
        id,
        link,
        md5_image,
        position,
        preview,
        rank,
        title,
        title_short,
        title_version,
        type
    )
}

fun TrackEntity.toTrack(album: Album, artist: Artist): Track {
    return Track(
        album = album,
        artist = artist,
        duration,
        explicit_content_cover,
        explicit_content_lyrics,
        explicit_lyrics,
        id,
        link,
        md5_image,
        position,
        preview,
        rank,
        title,
        title_short,
        title_version,
        type
    )
}

fun TrackDto.toTrackEntity(): TrackEntity {
    return TrackEntity(
        id = id,
        albumId =  album.id,
        artist = artist.id,
        duration = duration,
        explicit_content_cover = explicit_content_cover,
        explicit_content_lyrics = explicit_content_lyrics,
        explicit_lyrics = explicit_lyrics,
        link = link,
        md5_image = md5_image,
        position = position,
        preview = preview,
        rank = rank,
        title = title,
        title_short = title_short,
        title_version = title_version,
        type = type
    )
}

