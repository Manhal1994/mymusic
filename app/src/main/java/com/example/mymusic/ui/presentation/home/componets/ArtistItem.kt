package com.example.mymusic.ui.presentation.home.componets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.mymusic.domain.model.Artist
import com.example.mymusic.domain.model.Track

/**
 * Created by ManhalKhwashki on 3/21/2024.
 */

@Composable
fun ArtistItem(artist: Artist) {
    Row(horizontalArrangement = Arrangement.SpaceBetween,modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)) {
        Row(modifier = Modifier.weight(1f)) {
            Image(
                painter = rememberAsyncImagePainter(artist.picture),
                contentDescription = null,
                modifier = Modifier.size(64.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column() {
                Text(text = artist.name, color = Color.Black)
                Text(text = artist.type, color = Color.Gray)
            }

        }
        IconButton(onClick = { }) {
            Icon( Icons.Outlined.Favorite, contentDescription = "Favorite", tint = Color.Red, modifier = Modifier.size(24.dp))
        }
    }
}