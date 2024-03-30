package com.example.mymusic.data.remote

import com.example.mymusic.data.remote.dto.ChartDto
import retrofit2.http.GET

/**
 * Created by ManhalKhwashki on 3/14/2024.
 */

interface MusicApi {
    @GET("chart/")
    suspend fun getChart(
    ): ChartDto

    companion object {
        const val BASE_URL = "https://api.deezer.com/"
    }
}