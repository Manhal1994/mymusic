package com.example.mymusic.data.repository

import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.util.Log
import com.example.mymusic.data.local.MusicDatabase
import com.example.mymusic.data.local.entities.AlbumEntity
import com.example.mymusic.data.local.entities.ArtistEntity
import com.example.mymusic.data.local.entities.TrackEntity
import com.example.mymusic.data.mapper.*
import com.example.mymusic.data.remote.MusicApi
import com.example.mymusic.data.remote.dto.ChartDto
import com.example.mymusic.domain.model.Albums
import com.example.mymusic.domain.model.Artists
import com.example.mymusic.domain.model.Chart
import com.example.mymusic.domain.model.Tracks
import com.example.mymusic.domain.repository.MusicRepository
import com.example.mymusic.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.Retrofit
import javax.inject.Inject


/**
 * Created by ManhalKhwashki on 3/15/2024.
 */

class MusicRepositoryImpl @Inject constructor(
    private val musicApi: MusicApi, private val db: MusicDatabase,
) : MusicRepository {

    private val albumDao = db.albumDao
    private val tracksDao = db.trackDao
    private val artistDao = db.artistDao


    override suspend fun getChart(): Flow<Resource<Chart>> {
        return flow {
            emit(Resource.Loading<Chart>(true))
            try {
                val chartDto = musicApi.getChart()

                albumDao.clearAlbums()
                artistDao.clearArtists()
                tracksDao.clearTracks()

                artistDao.insertArtists(chartDto.artists.data.map { it.toArtistEntity() })
                tracksDao.insertTracks(chartDto.tracks.data.map {
                    albumDao.insertAlbums(listOf(it.album.toAlbumEntity()))
                    artistDao.insertArtists(listOf(it.artist.toArtistEntity()))
                    it.toTrackEntity()
                }
                )


                emit(Resource.Success(chartDto.toChart()))
                emit(Resource.Loading<Chart>(false))


            } catch (e: Exception) {
                if (e is IOException) {
                    loadFromCache().collect {
                        emit(it)
                    }

                } else {
                    emit(Resource.Error<Chart>(e.message ?: "Something went wrong"))
                    emit(Resource.Loading<Chart>(false))
                }


            }

        }
    }

    private suspend fun loadFromCache(): Flow<Resource<Chart>> {
        return flow {
            val albums: List<AlbumEntity> = albumDao.getAlbums()
            val artists: List<ArtistEntity> = artistDao.getArtists()
            val tracks: List<TrackEntity> = tracksDao.getTracks()

            val chart = Chart(
                albums = Albums(albums.map { it.toAlbum() }, albums.size),
                artists = Artists(artists.map { it.toArtist() }, artists.size),

                tracks = Tracks(
                    tracks.map {
                        val album = albumDao.getAlbumById(it.albumId)
                            ?: throw Exception("no album with id ${it.id}")
                        val artist = artistDao.getArtistById(it.artist)
                        artistDao.getArtistById(it.id)
                        it.toTrack(album = album.toAlbum(), artist = artist.toArtist())
                    },
                    tracks.size
                )
            )


            emit(Resource.Success(chart,"No Internet Connection"))
            emit(Resource.Loading<Chart>(false))
        }
    }

}