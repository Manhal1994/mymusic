package com.example.mymusic.ui.presentation.util

/**
 * Created by ManhalKhwashki on 3/21/2024.
 */

sealed class Screen(val route: String) {
    object TracksScreen: Screen("tracks")
    object ArtistsScreen: Screen("artists")
    object AlbumsScreen: Screen("albums")
    object TrackDetailScreen: Screen("trackDetail")


}