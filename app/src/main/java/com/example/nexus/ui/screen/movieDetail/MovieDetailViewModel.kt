package com.example.nexus.ui.screen.movieDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nexus.common.Resource
import com.example.nexus.domain.model.Movie
import com.example.nexus.domain.usecase.movies.MoviesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MovieDetailViewModel(
    private val moviesUseCase: MoviesUseCase
) : ViewModel() {

    private val _movieDetailState = MutableStateFlow<MovieState<Movie>>(MovieState.Loading)
    val movieDetailState: StateFlow<MovieState<Movie>> = _movieDetailState.asStateFlow()

    fun loadMovieDetail(page: Int = 1, movieId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            delay(50)
            moviesUseCase.getMovieById.invoke(movieId).collect { resource ->
                _movieDetailState.value = when (resource) {
                    is Resource.Loading -> MovieState.Loading
                    is Resource.Success -> MovieState.Success(resource.data)
                    is Resource.Error -> MovieState.Error(resource.message)
                }
            }
        }
    }
}