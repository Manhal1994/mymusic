package com.example.mymusic.ui.presentation.home.albums

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mymusic.ui.presentation.home.HomeActivityViewModel
import com.example.mymusic.ui.presentation.home.componets.AlbumItem
import com.example.mymusic.ui.presentation.home.componets.ArtistItem

/**
 * Created by ManhalKhwashki on 3/21/2024.
 */

@Composable
fun AlbumsScreen(viewModel: HomeActivityViewModel) {
    val state = viewModel.state.value

    if (state.isLoading)
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

            CircularProgressIndicator()
        }
    else LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(count = state.chart!!.albums!!.total) { index ->
            AlbumItem(state.chart.albums!!.data[index])
        }
    }
}