package com.example.mymusic.ui.presentation.home.trackDetail

import android.app.Activity
import android.util.DisplayMetrics
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.mymusic.ui.presentation.home.HomeActivityViewModel


/**
 * Created by ManhalKhwashki on 3/29/2024.
 */

@Composable
fun TrackDetailsScreen(viewModel: HomeActivityViewModel) {
    val context = LocalContext.current as Activity
    remember {
        val displayMetrics = DisplayMetrics()
        context.getWindowManager().defaultDisplay.getMetrics(displayMetrics)
        val height = displayMetrics.heightPixels
        val width = displayMetrics.widthPixels
        viewModel.decodeUrlImage(width, height)

    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(painter = rememberAsyncImagePainter(viewModel.trackDetailBgState.value))
    ) {
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Playing from top chart",
            modifier = Modifier.fillMaxWidth(),
            style = TextStyle(
                color = Color.White,
                fontSize = 13.sp,
                letterSpacing = 1.3.sp,
                textAlign = TextAlign.Center
            )
        )
        Spacer(modifier = Modifier.height(50.dp))

        Image(
            painter = rememberAsyncImagePainter("https://e-cdns-images.dzcdn.net/images/artist/c1eaf89e540f70dc017b206e70ac60c8/500x500-000000-80-0-0.jpg"),
            contentDescription = "Artist image",
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
                .weight(1f)
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
            ) {


                Text(text = "El Kawalean", style = MaterialTheme.typography.h6, color = Color.White)
                Text(
                    text = "Melhem Barkat, Fairuz, Eli Choueiri",
                    style = MaterialTheme.typography.subtitle2.copy(color = Color.Gray)
                )
                Spacer(modifier = Modifier.height(20.dp))
                Slider(
                    enabled = true,
                    colors = SliderDefaults.colors(
                        thumbColor = Color.White,
                        activeTrackColor = Color.White,
                        inactiveTrackColor = Color.Gray,


                        ),
                    value = 0.5f, onValueChange = {

                    })
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "0.00", style = TextStyle(color = Color.Gray, fontSize = 13.sp))
                    Text(text = "0.30", style = TextStyle(color = Color.Gray, fontSize = 13.sp))


                }
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    IconButton(onClick = { }) {
                        Icon(
                            Icons.Outlined.Favorite,
                            contentDescription = "Fav",
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )

                    }
                    Row() {
                        IconButton(onClick = { }) {
                            Icon(
                                Icons.Outlined.ArrowBack,
                                tint = Color.White,
                                contentDescription = "Forward", modifier = Modifier.size(32.dp)
                            )

                        }
                        Box(
                            modifier = Modifier
                                .size(64.dp)
                                .clip(shape = CircleShape)
                                .background(color = Color.White),
                            contentAlignment = Alignment.Center

                        ) {
                            Icon(
                                Icons.Filled.PlayArrow,
                                tint = Color.Black,
                                contentDescription = "Play",
                                modifier = Modifier.size(48.dp)
                            )
                        }


                        IconButton(onClick = { }) {
                            Icon(
                                Icons.Outlined.ArrowForward,
                                tint = Color.White,
                                contentDescription = "Backward",
                                modifier = Modifier.size(32.dp)
                            )

                        }

                    }
                    IconButton(onClick = { }) {
                        Icon(
                            Icons.Outlined.Share,
                            contentDescription = "Fav",
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )

                    }

                }
                Spacer(modifier = Modifier.height(30.dp))


            }


        }
    }
}