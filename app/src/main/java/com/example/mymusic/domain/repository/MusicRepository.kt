package com.example.mymusic.domain.repository

import com.example.mymusic.domain.model.Chart
import com.example.mymusic.util.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by ManhalKhwashki on 3/14/2024.
 */

interface MusicRepository {
     suspend fun getChart(): Flow<Resource<Chart>>
}