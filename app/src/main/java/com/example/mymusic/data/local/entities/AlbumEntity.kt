package com.example.mymusic.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mymusic.data.remote.dto.*

/**
 * Created by ManhalKhwashki on 3/24/2024.
 */

@Entity(tableName = "albums")
data class AlbumEntity(
    @PrimaryKey
    val id: Long,
    val cover: String?,
    val cover_big: String?,
    val cover_medium: String?,
    val cover_small: String?,
    val cover_xl: String?,
    val md5_image: String?,
    val title: String,
    val tracklist: String?,
    val type: String?
)