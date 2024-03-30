package com.example.mymusic.data.mapper

import com.example.mymusic.data.remote.dto.UserDto
import com.example.mymusic.domain.model.User

/**
 * Created by ManhalKhwashki on 3/20/2024.
 */


fun UserDto.toUser(): User {
    return User(id, name, tracklist, type)
}