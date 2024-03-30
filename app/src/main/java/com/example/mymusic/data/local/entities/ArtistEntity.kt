package com.example.mymusic.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by ManhalKhwashki on 3/24/2024.
 */

@Entity(tableName = "artists")
data class ArtistEntity(
    @PrimaryKey
    val id: Long,
    val link: String,
    val name: String,
    val picture: String,
    val picture_big: String,
    val picture_medium: String,
    val picture_small: String,
    val picture_xl: String,
    val position: Int,
    val radio: Boolean,
    val tracklist: String,
    val type: String,

)
