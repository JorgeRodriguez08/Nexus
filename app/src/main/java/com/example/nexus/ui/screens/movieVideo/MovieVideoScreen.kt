package com.example.nexus.ui.screens.movieVideo

import android.app.Activity
import android.content.pm.ActivityInfo
import android.view.View
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.viewinterop.AndroidView
import coil.compose.AsyncImage

@Composable
fun MovieVideoScreen(
    videoUrl: String?,
    movieVideoViewModel: MovieVideoViewModel,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val activity = context as? Activity

    LaunchedEffect(Unit) {
        movieVideoViewModel.setPlayingState(isPlaying = true)
        movieVideoViewModel.setVideoLoadingState(isLoading = true)
    }

    val isPlaying by movieVideoViewModel.isPlaying.collectAsState()
    val isVideoLoading by movieVideoViewModel.isVideoLoading.collectAsState()

    if (isPlaying) {
        val youtubePlayerView = remember { YouTubePlayerView(context) }
        DisposableEffect(Unit) {
            val originalOrientation = activity?.requestedOrientation
            val originalFlags = activity?.window?.decorView?.systemUiVisibility

            activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
            activity?.window?.decorView?.systemUiVisibility =
                View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY


            youtubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    movieVideoViewModel.setVideoLoadingState(false)
                    youTubePlayer.loadVideo(videoUrl ?: "", 3f)
                }
            })
            onDispose {
                activity?.requestedOrientation = originalOrientation ?: ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
                activity?.window?.decorView?.systemUiVisibility = originalFlags ?: 0
                youtubePlayerView.release()
            }
        }

        if (!isVideoLoading) {
            AndroidView(
                factory = { youtubePlayerView },
                modifier = Modifier.fillMaxSize()
            )
        }
    }


}