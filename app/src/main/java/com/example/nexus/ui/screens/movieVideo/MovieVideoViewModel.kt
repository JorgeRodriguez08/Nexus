package com.example.nexus.ui.screens.movieVideo

import androidx.lifecycle.ViewModel
import com.example.nexus.domain.usecase.movies.MoviesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MovieVideoViewModel() : ViewModel() {

    private val _movieVideoState = MutableStateFlow<MovieVideoState>(MovieVideoState.Loading)
    val movieVideoState: StateFlow<MovieVideoState> = _movieVideoState.asStateFlow()

    private val _isPlaying = MutableStateFlow(false)
    val isPlaying: StateFlow<Boolean> = _isPlaying.asStateFlow()

    private val _isVideoLoading = MutableStateFlow(false)
    val isVideoLoading: StateFlow<Boolean> = _isVideoLoading.asStateFlow()

    fun setPlayingState(isPlaying: Boolean) {
        _isPlaying.value = isPlaying
    }

    fun setVideoLoadingState(isLoading: Boolean) {
        _isVideoLoading.value = isLoading
    }

}