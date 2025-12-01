package com.example.nexus.ui.screens.movieDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nexus.common.Resource
import com.example.nexus.domain.usecase.movies.MoviesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
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
            moviesUseCase.getMovieIntegrate.invoke(movieId).collect { resource ->
                _movieDetailState.value = when (resource) {
                    is Resource.Loading -> MovieDetailState.Loading
                    is Resource.Success -> MovieDetailState.Success(resource.data)
                    is Resource.Error -> MovieDetailState.Error(resource.message)
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


