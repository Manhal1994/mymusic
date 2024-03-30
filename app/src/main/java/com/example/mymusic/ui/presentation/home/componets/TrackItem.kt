package com.example.mymusic.ui.presentation.home.componets

import android.content.Context
import android.content.res.Resources.Theme
import android.media.MediaPlayer
import android.net.Uri
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material.icons.outlined.PlayCircle
import androidx.compose.material.icons.rounded.Pause
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.mymusic.domain.model.Track

/**
 * Created by ManhalKhwashki on 3/18/2024.
 */

@Composable
fun TrackItem(track: Track, context: Context) {

    Column {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        ) {
            Row(modifier = Modifier.weight(1f)) {
                Image(
                    painter = rememberAsyncImagePainter(track.artist.picture),
                    contentDescription = null,
                    modifier = Modifier.size(64.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column() {
                    Text(text = track.title, color = Color.Black)
                    Text(text = track.artist.name, color = Color.Gray)
                }
            }
            AnimatedCircularPlay(
                url = track.preview,
                context = context,
                color = MaterialTheme.colors.primary
            )


        }
        Spacer(modifier = Modifier.height(1.dp))
        Box(
            Modifier
                .height(0.2.dp)
                .fillMaxWidth()
                .padding(horizontal = 4.dp)
                .background(color = Color.Black)){

        }
        Spacer(modifier = Modifier.height(10.dp))


    }
}

@Composable
fun AnimatedCircularPlay(
    color: Color = Color.Gray,
    radius: Float = 40f,
    context: Context,
    url: String
) {
    var player by remember { mutableStateOf<MediaPlayer?>(null) }
    val currentPosition = remember { mutableStateOf<Float>(0f) }
    val isPlaying = remember { mutableStateOf<Boolean>(false) }
    var sec   = 0
    val mHandler by remember {
        mutableStateOf<Handler>(Handler(Looper.getMainLooper()))
    }
    val runnable by remember {

        mutableStateOf(object : Runnable {
            override fun run() {
                sec++
                if (player != null) {
                    currentPosition.value =
                        player!!.currentPosition / player!!.duration.toFloat() * 360

                    if (sec <= player?.duration!!/1000 && isPlaying.value) {
                        mHandler.postDelayed(this, 1000)

                    }
                    else {
                       sec = 0
                        isPlaying.value = false
                    }
              }
            }

        })
    }


    fun togglePlay() {

        if (player == null) {
            Log.d("togglePlay", ":created ")
            player = MediaPlayer.create(context, Uri.parse(url))
        }

        if ((player?.isPlaying) == true) {
            player?.pause()
            isPlaying.value = false;
        } else {
            isPlaying.value = true
            player?.start()
        }


        mHandler.postDelayed(runnable, 1000)
    }

    Box(
        modifier = Modifier
            .width(radius.dp)
            .height(radius.dp)
    ) {

        Crossfade(targetState = isPlaying.value) { checked ->
            if (checked) {
                Icon(
                    imageVector = Icons.Rounded.Pause,
                    contentDescription = "pause",
                    tint = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .size(radius.dp)
                        .height(radius.dp)
                        .clickable { togglePlay() },
                )
            } else {
                Icon(
                    imageVector = Icons.Rounded.PlayArrow,
                    contentDescription = "Favorite",
                    tint = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .size(radius.dp)
                        .height(radius.dp)
                        .clickable { togglePlay() },
                )
            }
        }

        Canvas(
            modifier = Modifier
                .width(radius.dp)
                .height(radius.dp)
        ) {
            drawArc(
                color = color,
                startAngle = -90f,
                sweepAngle = currentPosition.value.toFloat(),
                useCenter = false,
                style = Stroke(2.dp.toPx(), cap = StrokeCap.Round)
            )

        }
    }

}