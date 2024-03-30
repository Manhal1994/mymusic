package com.example.mymusic.di

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.room.Room
import com.example.mymusic.data.local.MusicDatabase
import com.example.mymusic.data.remote.MusicApi
import com.example.mymusic.domain.repository.MusicRepository
import com.example.mymusic.domain.use_case.GetChart
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton


/**
 * Created by ManhalKhwashki on 3/15/2024.
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMusicApi(): MusicApi {
        return Retrofit.Builder()
            .baseUrl(MusicApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor()
                        .apply { level = HttpLoggingInterceptor.Level.BASIC })
                    .build()
            ).build().create()

    }

    @Provides
    @Singleton
    fun provideMusicDatabase(app: Application): MusicDatabase {
        return Room.databaseBuilder(
            app,
            MusicDatabase::class.java,
            "musicdb.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideGetTopTracksUseCase(musicRepository : MusicRepository): GetChart {
      return GetChart(musicRepository)
    }


}