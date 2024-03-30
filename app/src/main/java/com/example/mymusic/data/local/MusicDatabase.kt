package com.example.mymusic.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mymusic.data.local.dao.AlbumDao
import com.example.mymusic.data.local.dao.ArtistDao
import com.example.mymusic.data.local.dao.TrackDao
import com.example.mymusic.data.local.entities.AlbumEntity
import com.example.mymusic.data.local.entities.ArtistEntity
import com.example.mymusic.data.local.entities.TrackEntity

/**
 * Created by ManhalKhwashki on 3/24/2024.
 */

@Database(
    entities = [ArtistEntity::class, AlbumEntity::class, TrackEntity::class],
    version = 1
)

abstract class MusicDatabase: RoomDatabase() {
    abstract val trackDao: TrackDao
    abstract val albumDao: AlbumDao
    abstract val artistDao: ArtistDao

}