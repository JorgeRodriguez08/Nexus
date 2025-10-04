package com.example.nexus.ui.screens.movieDetail

sealed class VideoState<out Video> {
    object Loading : VideoState<Nothing>()
    data class Success<Video>(val data: Video) : VideoState<Video>()
    data class Error(val message: String) : VideoState<Nothing>()
}