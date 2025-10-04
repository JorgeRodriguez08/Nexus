package com.example.nexus.ui.screens.movieDetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import coil.compose.AsyncImage
import com.example.nexus.R
import com.example.nexus.domain.model.Movie
import com.example.nexus.domain.model.Video
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

@Composable
fun MovieDetailCard(
    movie: Movie,
    video: Video,
    movieDetailViewModel: MovieDetailViewModel,
    modifier: Modifier = Modifier
) {
    val isPlaying by movieDetailViewModel.isPlaying.collectAsState()
    val isVideoLoading by movieDetailViewModel.isVideoLoading.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(7.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1.7f),
            shape = RectangleShape
        ) {
            if (isPlaying) {
                val context = LocalContext.current
                val youtubePlayerView = remember { YouTubePlayerView(context) }
                DisposableEffect(Unit) {
                    youtubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                        override fun onReady(youTubePlayer: YouTubePlayer) {
                            movieDetailViewModel.setVideoLoadingState(false)
                            youTubePlayer.loadVideo(video.key, 0f)
                        }
                    })
                    onDispose { youtubePlayerView.release() }
                }
                if (isVideoLoading) {
                    AsyncImage(
                        model = movie.posterUrl,
                        contentDescription = movie.title,
                        modifier = Modifier.fillMaxSize(),
                        placeholder = painterResource(R.drawable.sonic),
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center
                    )
                } else {
                    AndroidView(
                        factory = { youtubePlayerView },
                        modifier = Modifier.fillMaxSize()
                    )
                }
            } else {
                AsyncImage(
                    model = movie.posterUrl,
                    contentDescription = movie.title,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.TopCenter
                )
            }
        }

        Text(
            text = movie.title,
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
        ) {
            Text(
                text = movie.releaseDate.substring(0, 4),
                color = MaterialTheme.colorScheme.onSurface
            )
            Card(shape = RectangleShape) {
                Text(
                    text = if (movie.adult) "16-" else "16+",
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
            Text(
                text = "1 h 53 min",
                color = MaterialTheme.colorScheme.onSurface
            )
        }

        Button(
            onClick = {
                movieDetailViewModel.setPlayingState(true)
                movieDetailViewModel.setVideoLoadingState(true)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.onSurface,
                contentColor = MaterialTheme.colorScheme.surface
            ),
            enabled = true,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .padding(bottom = 2.dp),
            shape = RoundedCornerShape(2.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.PlayArrow,
                contentDescription = "Ver",
                modifier = Modifier.size(35.dp)
            )
            Text(
                text = "Ver",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold
            )
        }

        Button(
            onClick = {
            },
            enabled = false,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.onSurface,
                contentColor = MaterialTheme.colorScheme.surface
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .padding(bottom = 2.dp),
            shape = RoundedCornerShape(2.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.vertical_align_bottom),
                contentDescription = "Descargar",
                modifier = Modifier.size(35.dp)
            )
            Text(
                text = "Descargar",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold
            )
        }

        Text(
            text = movie.overview,
            fontSize = 17.sp,
            color = MaterialTheme.colorScheme.onSurface
        )

        Text(
            text = "Protagonistas: Liam Hemsworth, Russell Crowe, Luke Hemsworth",
            color = MaterialTheme.colorScheme.onSurface

        )

        Text(
            text = "Dirección: William Eubank",
            color = MaterialTheme.colorScheme.onSurface
        )

    }
}