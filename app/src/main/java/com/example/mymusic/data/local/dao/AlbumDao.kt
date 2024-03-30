package com.example.mymusic.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mymusic.data.local.entities.AlbumEntity

/**
 * Created by ManhalKhwashki on 3/24/2024.
 */

@Dao
interface AlbumDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAlbums(albums: List<AlbumEntity>)

    @Query("SELECT * FROM albums")
    suspend fun getAlbums(): List<AlbumEntity>

    @Query("SELECT * FROM albums where id == :id")
    suspend fun getAlbumById(id: Long):AlbumEntity?

    @Query("DELETE FROM albums")
    suspend fun clearAlbums()
}