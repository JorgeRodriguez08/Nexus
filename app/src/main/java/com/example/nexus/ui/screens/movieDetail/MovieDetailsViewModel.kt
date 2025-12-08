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

class MovieDetailsViewModel(
    private val moviesUseCase: MoviesUseCase
) : ViewModel() {

    private val _movieDetailsState = MutableStateFlow<MovieDetailsState>(MovieDetailsState.Loading)
    val movieDetailsState: StateFlow<MovieDetailsState> = _movieDetailsState.asStateFlow()

    fun loadMovieDetails(movieId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            moviesUseCase.getMovieDetails.invoke(movieId).collect { resource ->
                _movieDetailsState.value = when (resource) {
                    is Resource.Loading -> MovieDetailsState.Loading
                    is Resource.Success -> MovieDetailsState.Success(resource.data)
                    is Resource.Error -> MovieDetailsState.Error(resource.message)
                }
            }
        }
    }
}


