package com.example.mymusic.ui.presentation.home.tracks

import android.content.Context
import android.media.MediaPlayer
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mymusic.ui.presentation.home.HomeActivityViewModel
import com.example.mymusic.ui.presentation.home.componets.TrackItem
import kotlinx.coroutines.flow.collectLatest

/**
 * Created by ManhalKhwashki on 3/16/2024.
 */

@Composable
fun TracksScreen(viewModel: HomeActivityViewModel, context: Context) {
    val state = viewModel.state.value



    if(state.isLoading)
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

            CircularProgressIndicator()
        }

    else if(state.chart!=null) LazyColumn(modifier = Modifier.padding(16.dp)){
       items(count = state.chart.tracks.total){index->
           TrackItem(state.chart.tracks.data[index], context)
       }
   }
    else {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

            CircularProgressIndicator()
        }
    }
}