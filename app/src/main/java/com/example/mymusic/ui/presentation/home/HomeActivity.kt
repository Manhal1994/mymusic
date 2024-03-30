package com.example.mymusic.ui.presentation.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Album
import androidx.compose.material.icons.filled.Audiotrack
import androidx.compose.material.icons.filled.MusicVideo
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Album
import androidx.compose.material.icons.outlined.Audiotrack
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState

import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mymusic.ui.presentation.home.BottomNavigationItem
import com.example.mymusic.ui.presentation.home.albums.AlbumsScreen
import com.example.mymusic.ui.presentation.home.artist.ArtistScreen
import com.example.mymusic.ui.presentation.home.componets.ArtistItem
import com.example.mymusic.ui.presentation.home.trackDetail.TrackDetailsScreen
import com.example.mymusic.ui.presentation.home.tracks.TracksScreen
import com.example.mymusic.ui.presentation.util.Screen
import com.example.mymusic.ui.theme.MyMusicTheme
import com.example.mymusic.ui.theme.MyMusicTheme

import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class HomeActivity() : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: HomeActivityViewModel = hiltViewModel()
            val navController = rememberNavController()
            val scaffoldState = rememberScaffoldState()


            LaunchedEffect(key1 = true) {
                viewModel.eventFlow.collectLatest {
                    if(it is HomeActivityViewModel.UiEvent.ShowSnackbar)
                     scaffoldState.snackbarHostState.showSnackbar(it.message)
                }
            }
            MyMusicTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Scaffold(
                        scaffoldState = scaffoldState,
                        bottomBar = {
                           if((navController.currentBackStackEntry?.destination?.route
                                   ?: "/") != Screen.TrackDetailScreen.route
                           ) BottomNavigation(backgroundColor = Color.White) {
                                val navBackStackEntry by navController.currentBackStackEntryAsState()
                                val currentRoute = navBackStackEntry?.destination?.route

                                items.forEach { 
                                    BottomNavigationItem(selected = currentRoute==it.route, onClick = {
                                        navController.navigate(it.route) {
                                            popUpTo(navController.graph.startDestinationId)
                                            launchSingleTop = true
                                        }
                                    },  icon = { Icon(it.selectedIcon, contentDescription = null) })

                                }
                            }
                        }
                    ) {
                        NavHost(navController, startDestination = Screen.TrackDetailScreen.route) {
                            composable(Screen.TracksScreen.route) {
                                TracksScreen(viewModel = viewModel, this@HomeActivity)
                            }
                            composable(Screen.ArtistsScreen.route) {
                                ArtistScreen(viewModel = viewModel)
                            }
                            composable(Screen.TrackDetailScreen.route) {
                                TrackDetailsScreen(viewModel = viewModel)
                            }

                        }

                    }
                }
            }
        }
    }
}

val items = listOf(
    BottomNavigationItem(Screen.TracksScreen.route,selectedIcon = Icons.Outlined.Audiotrack),
    BottomNavigationItem(Screen.ArtistsScreen.route,selectedIcon = Icons.Outlined.Person),

)

data class BottomNavigationItem(
    val route: String,
    val selectedIcon: ImageVector,

)



