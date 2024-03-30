package com.example.mymusic.data.mapper

import com.example.mymusic.data.remote.dto.PodcastDto
import com.example.mymusic.data.remote.dto.PodcastsDto
import com.example.mymusic.domain.model.Podcast
import com.example.mymusic.domain.model.Podcasts

/**
 * Created by ManhalKhwashki on 3/20/2024.
 */

fun PodcastsDto.toPodcasts(): Podcasts {
    return Podcasts(data = data.map { it.toPodcast() }, total = total)

}

fun PodcastDto.toPodcast(): Podcast {
    return Podcast(available, description, fans, id, link, picture, picture_big, picture_medium, picture_small, picture_xl, share, title, type)
}