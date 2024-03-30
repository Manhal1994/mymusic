package com.example.mymusic.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mymusic.data.local.entities.ArtistEntity
import com.example.mymusic.data.local.entities.TrackEntity

/**
 * Created by ManhalKhwashki on 3/25/2024.
 */

@Dao
interface TrackDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTracks(albums: List<TrackEntity>)

    @Query("SELECT * FROM tracks")
    suspend fun getTracks(): List<TrackEntity>

    @Query("DELETE FROM tracks")
    suspend fun clearTracks()
}