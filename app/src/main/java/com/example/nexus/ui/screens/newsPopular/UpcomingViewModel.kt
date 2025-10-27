package com.example.nexus.ui.screens.newsPopular

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nexus.common.Resource
import com.example.nexus.domain.model.Movie
import com.example.nexus.domain.usecase.movies.MoviesUseCase
import com.example.nexus.domain.usecase.series.SeriesUseCase
import com.example.nexus.ui.screens.movies.MoviesState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UpcomingViewModel(
    private val moviesUseCase: MoviesUseCase
) : ViewModel() {

    private val _moviesUiState = MutableStateFlow<MoviesState<Movie>>(MoviesState.Loading)
    val moviesUiState: StateFlow<MoviesState<Movie>> = _moviesUiState.asStateFlow()

    fun loadMoviesUpcoming(page: Int = 1) {
        viewModelScope.launch(Dispatchers.IO) {
            moviesUseCase.getMoviesUpComing.invoke(page).collect { resource ->
                _moviesUiState.value = when (resource) {
                    is Resource.Loading -> MoviesState.Loading
                    is Resource.Success -> MoviesState.Success(resource.data)
                    is Resource.Error -> MoviesState.Error(resource.message)
                }
            }
        }
    }


}