package com.example.nexus.ui.screens.movieDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nexus.common.Resource
import com.example.nexus.domain.usecase.movies.MoviesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch

class MovieDetailViewModel(
    private val moviesUseCase: MoviesUseCase
) : ViewModel() {

    private val _movieDetailState = MutableStateFlow<MovieDetailState>(MovieDetailState.Loading)
    val movieDetailState: StateFlow<MovieDetailState> = _movieDetailState.asStateFlow()

    private val _isPlaying = MutableStateFlow(false)
    val isPlaying: StateFlow<Boolean> = _isPlaying.asStateFlow()

    private val _isVideoLoading = MutableStateFlow(false)
    val isVideoLoading: StateFlow<Boolean> = _isVideoLoading.asStateFlow()

    private val _isFullScreen = MutableStateFlow(false)
    val isFullScreen: StateFlow<Boolean> = _isFullScreen.asStateFlow()

    fun loadMovieDetail(movieId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            delay(50)
            val movieResource = moviesUseCase.getMovieById.invoke(movieId)
            val videoResource = moviesUseCase.getMovieVideo.invoke(movieId)
            val castResource = moviesUseCase.getMovieCast.invoke(movieId)
            val crewResource = moviesUseCase.getMovieCrew.invoke(movieId)

            combine(movieResource, videoResource, castResource, crewResource) { movie, video, cast, crew ->
                Quadruple(movie, video, cast, crew)
            }.collect { (movie, video, cast, crew) ->
                _movieDetailState.value = when {
                    movie is Resource.Loading || video is Resource.Loading || cast is Resource.Loading || crew is Resource.Loading  -> MovieDetailState.Loading
                    movie is Resource.Success && video is Resource.Success && cast is Resource.Success && crew is Resource.Success -> MovieDetailState.Success(movie.data, video.data, cast.data, crew.data)
                    else -> MovieDetailState.Error("Failed to load movie or video")
                }
            }
        }
    }

    fun setPlayingState(isPlaying: Boolean) {
        _isPlaying.value = isPlaying
    }

    fun setVideoLoadingState(isLoading: Boolean) {
        _isVideoLoading.value = isLoading
    }

    fun setFullScreenState(isFullScreen: Boolean) {
        _isFullScreen.value = isFullScreen
    }
}


