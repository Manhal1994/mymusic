package com.example.mymusic.data.mapper

import com.example.mymusic.data.local.entities.AlbumEntity
import com.example.mymusic.data.local.entities.ArtistEntity
import com.example.mymusic.data.remote.dto.AlbumDto
import com.example.mymusic.data.remote.dto.ArtistDto
import com.example.mymusic.data.remote.dto.ArtistsDto
import com.example.mymusic.domain.model.Artist
import com.example.mymusic.domain.model.Artists

/**
 * Created by ManhalKhwashki on 3/17/2024.
 */

fun ArtistsDto.toArtists(): Artists {
    return Artists(
        data = data.map { it.toArtists() },
        total = total
    )
}

fun ArtistDto.toArtists(): Artist {
    return Artist(
        id = id,
        link = link,
        name = name,
        picture = picture,
        picture_big = picture_big,
        picture_medium = picture_medium,
        picture_small = picture_small,
        picture_xl = picture_xl,
        position = position,
        radio = radio,
        tracklist = tracklist,
        type = type
    )
}

fun ArtistEntity.toArtist(): Artist {
    return Artist(
        id = id,
        link = link,
        name = name,
        picture = picture,
        picture_big = picture_big,
        picture_medium = picture_medium,
        picture_small = picture_small,
        picture_xl = picture_xl,
        position = position,
        radio = radio,
        tracklist = tracklist,
        type = type
    )
}

fun ArtistDto.toArtistEntity(): ArtistEntity {
    return ArtistEntity(
        id = id,
        link = link,
        name = name,
        picture = picture,
        picture_big = picture_big,
        picture_medium = picture_medium,
        picture_small = picture_small,
        picture_xl = picture_xl,
        position = position,
        radio = radio,
        tracklist = tracklist,
        type = type
    )
}