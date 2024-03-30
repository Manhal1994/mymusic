package com.example.mymusic.di

import com.example.mymusic.data.repository.MusicRepositoryImpl
import com.example.mymusic.domain.repository.MusicRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by ManhalKhwashki on 3/15/2024.
 */

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindStockRepository(
        musicRepositoryImpl: MusicRepositoryImpl
    ): MusicRepository
}