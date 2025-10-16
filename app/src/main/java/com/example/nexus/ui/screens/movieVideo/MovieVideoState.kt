package com.example.nexus.ui.screens.movieVideo

sealed class MovieVideoState {
    object Loading : MovieVideoState()
    data class Success(val videoUrl: String) : MovieVideoState()
    data class Error(val message: String) : MovieVideoState()
}