package com.example.mymusic.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mymusic.data.remote.dto.AlbumDto
import com.example.mymusic.data.remote.dto.ArtistDto

/**
 * Created by ManhalKhwashki on 3/25/2024.
 */

@Entity(tableName = "tracks")
data class TrackEntity(
    @PrimaryKey
    val id: Long,
    val albumId: Long,
    val artist: Long,
    val duration: Int,
    val explicit_content_cover: Int,
    val explicit_content_lyrics: Int,
    val explicit_lyrics: Boolean,
    val link: String,
    val md5_image: String,
    val position: Int,
    val preview: String,
    val rank: Int,
    val title: String,
    val title_short: String,
    val title_version: String,
    val type: String
)