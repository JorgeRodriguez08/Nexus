package com.example.nexus.ui.screens.movieDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nexus.common.core.Resource
import com.example.nexus.domain.usecase.movies.MoviesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MovieDetailsViewModel(
    private val moviesUseCase: MoviesUseCase
) : ViewModel() {

    private val _movieDetailState = MutableStateFlow<MovieDetailState>(MovieDetailState.Loading)
    val movieDetailState: StateFlow<MovieDetailState> = _movieDetailState.asStateFlow()

    fun loadMovieDetails(movieId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            moviesUseCase.getMovieDetails.invoke(movieId).collect { resource ->
                _movieDetailState.value = when (resource) {
                    is Resource.Loading -> MovieDetailState.Loading
                    is Resource.Success -> MovieDetailState.Success(resource.data)
                    is Resource.Error -> MovieDetailState.Error(resource.message)
                }
            }
        }
    }
}