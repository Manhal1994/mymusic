package com.example.mymusic.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mymusic.data.local.entities.AlbumEntity
import com.example.mymusic.data.local.entities.ArtistEntity

/**
 * Created by ManhalKhwashki on 3/24/2024.
 */


@Dao
interface ArtistDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArtists(albums: List<ArtistEntity>)

    @Query("SELECT * FROM artists")
    suspend fun getArtists(): List<ArtistEntity>

    @Query("SELECT * FROM artists where id == :id")
    suspend fun getArtistById(id: Long): ArtistEntity

    @Query("DELETE FROM artists")
    suspend fun clearArtists()
}