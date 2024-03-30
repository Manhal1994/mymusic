package com.example.mymusic.data.mapper

import com.example.mymusic.data.local.entities.AlbumEntity
import com.example.mymusic.data.remote.dto.AlbumDto
import com.example.mymusic.data.remote.dto.AlbumsDto
import com.example.mymusic.domain.model.Album
import com.example.mymusic.domain.model.Albums

/**
 * Created by ManhalKhwashki on 3/17/2024.
 */

fun AlbumsDto.toAlbums(): Albums {
    return Albums(
        data = data.map { it.toAlbum() },
        total = total
    )
}

fun AlbumDto.toAlbum(): Album{
    return Album(
        cover = cover,
        cover_big = cover_big,
        cover_medium = cover_medium,
        cover_small = cover_small,
        cover_xl = cover_xl,
        id = id,
        md5_image = md5_image,
        title = title,
        tracklist = tracklist,
        type = type
    )
}

fun AlbumEntity.toAlbum(): Album{
    return Album(
        cover = cover,
        cover_big = cover_big,
        cover_medium = cover_medium,
        cover_small = cover_small,
        cover_xl = cover_xl,
        id = id,
        md5_image = md5_image,
        title = title,
        tracklist = tracklist,
        type = type
    )
}


fun AlbumDto.toAlbumEntity(): AlbumEntity{
    return AlbumEntity(
        cover = cover,
        cover_big = cover_big,
        cover_medium = cover_medium,
        cover_small = cover_small,
        cover_xl = cover_xl,
        id = id,
        md5_image = md5_image,
        title = title,
        tracklist = tracklist,
        type = type
    )
}