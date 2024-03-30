package com.example.mymusic.domain.use_case

import com.example.mymusic.domain.model.Chart
import com.example.mymusic.domain.repository.MusicRepository
import com.example.mymusic.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by ManhalKhwashki on 3/16/2024.
 */
class GetChart @Inject constructor (private val musicRepository: MusicRepository) {

    suspend operator fun invoke(): Flow<Resource<Chart>> {
       return musicRepository.getChart()
    }

}