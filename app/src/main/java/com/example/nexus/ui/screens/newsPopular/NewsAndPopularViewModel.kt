package com.example.nexus.ui.screens.newsPopular

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nexus.common.Resource
import com.example.nexus.data.remote.constants.MoviesGenreIds
import com.example.nexus.domain.model.Movie
import com.example.nexus.domain.usecase.movies.MoviesUseCase
import com.example.nexus.ui.screens.movies.MoviesState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NewsAndPopularViewModel(
    private val moviesUseCase: MoviesUseCase
) : ViewModel() {

    private val _selectedFilter = MutableStateFlow<FilterType>(FilterType.Upcoming)
    val selectedFilter: StateFlow<FilterType> = _selectedFilter.asStateFlow()

    private val _moviesUiState = MutableStateFlow<MoviesState>(MoviesState.Loading)
    val moviesUiState: StateFlow<MoviesState> = _moviesUiState.asStateFlow()

    private val _moviesDetailStates = MutableStateFlow<Map<Int, MovieDetailState>>(emptyMap())
    val moviesDetailStates: StateFlow<Map<Int, MovieDetailState>> = _moviesDetailStates.asStateFlow()

    fun setFilter(filter: FilterType) {
        _selectedFilter.value = filter
        loadMoviesForFilter(filter)
    }

    private fun loadMoviesForFilter(filter: FilterType) {
        when (filter) {
            FilterType.Upcoming -> loadMoviesUpcoming()
            FilterType.Popular -> loadMoviesPopular()
            FilterType.MobileGames -> loadMobileGames()
            FilterType.Top10Movies -> loadTop10Movies()
            FilterType.Top10Series -> loadTop10Series()
        }
    }

    fun loadMoviesUpcoming(page: Int = 1) {
        viewModelScope.launch(Dispatchers.IO) {
            moviesUseCase.getMoviesUpComing.invoke(page).collect { resource ->
                _moviesUiState.value = when (resource) {
                    is Resource.Loading -> MoviesState.Loading
                    is Resource.Success -> {
                        resource.data.forEach { movie -> loadMovieDetail(movie.id) }
                        MoviesState.Success(resource.data)
                    }
                    is Resource.Error -> MoviesState.Error(resource.message)
                }
            }
        }
    }

    fun loadMoviesPopular(page: Int = 1) {
        viewModelScope.launch(Dispatchers.IO) {
            moviesUseCase.getMoviesPopular.invoke(page).collect { resource ->
                _moviesUiState.value = when (resource) {
                    is Resource.Loading -> MoviesState.Loading
                    is Resource.Success -> {
                        resource.data.forEach { movie -> loadMovieDetail(movie.id) }
                        MoviesState.Success(resource.data)
                    }
                    is Resource.Error -> MoviesState.Error(resource.message)
                }
            }
        }
    }

    fun loadMobileGames(page: Int = 1) {
        viewModelScope.launch(Dispatchers.IO) {
            moviesUseCase.getMoviesByGenre.invoke(MoviesGenreIds.ANIMATION, page).collect { resource ->
                _moviesUiState.value = when (resource) {
                    is Resource.Loading -> MoviesState.Loading
                    is Resource.Success -> {
                        resource.data.forEach { movie -> loadMovieDetail(movie.id) }
                        MoviesState.Success(resource.data)
                    }
                    is Resource.Error -> MoviesState.Error(resource.message)
                }
            }
        }
    }

    fun loadTop10Series(page: Int = 1) {

    }

    fun loadTop10Movies(page: Int = 1) {
        viewModelScope.launch(Dispatchers.IO) {
            moviesUseCase.getMoviesTopRated.invoke(page).collect { resource ->
                _moviesUiState.value = when (resource) {
                    is Resource.Loading -> MoviesState.Loading
                    is Resource.Success -> {
                        resource.data.forEach { movie -> loadMovieDetail(movie.id) }
                        MoviesState.Success(resource.data)
                    }
                    is Resource.Error -> MoviesState.Error(resource.message)
                }
            }
        }
    }

    fun loadMovieDetail(movieId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val newMap = _moviesDetailStates.value.toMutableMap()
            moviesUseCase.getMovieDetail.invoke(movieId).collect { resource ->
                newMap[movieId] = when (resource) {
                    is Resource.Loading -> MovieDetailState.Loading
                    is Resource.Success -> MovieDetailState.Success(resource.data)
                    is Resource.Error -> MovieDetailState.Error(resource.message)
                }
            }
            _moviesDetailStates.value = newMap
        }
    }
    
}