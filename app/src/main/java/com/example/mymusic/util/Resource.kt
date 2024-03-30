package com.example.mymusic.util

/**
 * Created by ManhalKhwashki on 3/14/2024.
 */
sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T?, message:String? = null) : Resource<T>(data = data, message = message)
    class Error<T>(message: String) : Resource<T>(message = message)
    class Loading<T>(val isLoading: Boolean = true) : Resource<T>(null)

}
