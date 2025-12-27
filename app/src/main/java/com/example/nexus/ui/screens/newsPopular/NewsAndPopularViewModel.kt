package com.example.nexus.ui.screens.newsPopular

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nexus.common.constants.MoviesGenreIds
import com.example.nexus.common.constants.NetworkConstants
import com.example.nexus.common.core.Resource
import com.example.nexus.domain.usecase.movies.MoviesUseCase
import com.example.nexus.domain.usecase.series.SeriesUseCase
import com.example.nexus.ui.components.filterbar.NewFilterType
import com.example.nexus.ui.screens.movieDetails.MovieDetailState
import com.example.nexus.ui.screens.movies.MovieCategory
import com.example.nexus.ui.screens.movies.MoviesState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NewsAndPopularViewModel(
    private val moviesUseCase: MoviesUseCase,
    private val seriesUseCase: SeriesUseCase
): ViewModel() {

    private val _selectedFilter = MutableStateFlow<NewFilterType>(NewFilterType.Upcoming)
    val selectedFilter: StateFlow<NewFilterType> = _selectedFilter.asStateFlow()

    private val _moviesUiState = MutableStateFlow<MoviesState>(MoviesState.Loading)
    val moviesUiState: StateFlow<MoviesState> = _moviesUiState.asStateFlow()

    private val _moviesDetailStates = MutableStateFlow<Map<Int, MovieDetailState>>(emptyMap())
    val moviesDetailStates: StateFlow<Map<Int, MovieDetailState>> = _moviesDetailStates.asStateFlow()

    fun setFilter(filter: NewFilterType) {
        _selectedFilter.value = filter
        loadMoviesForFilter(filter)
    }

    private fun loadMoviesForFilter(filter: NewFilterType) {
        when (filter) {
            NewFilterType.Upcoming -> loadMoviesUpcoming()
            NewFilterType.Popular -> loadMoviesPopular()
            NewFilterType.MobileGames -> loadMobileGames()
            NewFilterType.Top10Movies -> loadTop10Movies()
            NewFilterType.Top10Series -> loadTop10Series()
        }
    }

    fun loadMoviesUpcoming(page: Int = 1) {
        viewModelScope.launch(Dispatchers.IO) {
            moviesUseCase.getMoviesUpComing.invoke(page).collect { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        _moviesUiState.value = MoviesState.Loading
                    }
                    is Resource.Success -> {
                        _moviesUiState.value = MoviesState.Success(resource.data)
                        resource.data.forEach { movie -> loadMovieDetails(movie.id) }
                    }
                    is Resource.Error -> {
                        _moviesUiState.value = MoviesState.Error(resource.message)
                    }
                }
            }
        }
    }

    fun loadMoviesPopular(page: Int = 1) {
        viewModelScope.launch(Dispatchers.IO) {
            moviesUseCase.getMoviesPopular.invoke(page).collect { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        _moviesUiState.value = MoviesState.Loading
                    }
                    is Resource.Success -> {
                        _moviesUiState.value = MoviesState.Success(resource.data)
                        resource.data.forEach { movie -> loadMovieDetails(movie.id) }
                    }
                    is Resource.Error -> {
                        _moviesUiState.value = MoviesState.Error(resource.message)
                    }
                }
            }
        }
    }

    fun loadMobileGames(page: Int = 1) {
        viewModelScope.launch(Dispatchers.IO) {
            moviesUseCase.discoverMovies.invoke(MoviesGenreIds.ANIMATION, page, NetworkConstants.ORIGINAL_COUNTRY_US).collect { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        _moviesUiState.value = MoviesState.Loading
                    }
                    is Resource.Success -> {
                        _moviesUiState.value = MoviesState.Success(resource.data)
                        resource.data.forEach { movie -> loadMovieDetails(movie.id) }
                    }
                    is Resource.Error -> {
                        _moviesUiState.value = MoviesState.Error(resource.message)
                    }
                }
            }
        }
    }

    fun loadTop10Movies() {
        viewModelScope.launch(Dispatchers.IO) {
            moviesUseCase.getMoviesTrending.invoke().collect { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        _moviesUiState.value = MoviesState.Loading
                    }
                    is Resource.Success -> {
                        _moviesUiState.value = MoviesState.Success(resource.data)
                        resource.data.forEach { movie -> loadMovieDetails(movie.id) }
                    }
                    is Resource.Error -> {
                        _moviesUiState.value = MoviesState.Error(resource.message)
                    }
                }
            }
        }
    }

    fun loadTop10Series() {
    }

    fun loadMovieDetails(movieId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            updateMovieDetailStates(movieId, MovieDetailState.Loading)
            moviesUseCase.getMovieDetails.invoke(movieId).collect { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        updateMovieDetailStates(movieId, MovieDetailState.Loading)
                    }
                    is Resource.Success -> {
                        updateMovieDetailStates(movieId, MovieDetailState.Success(resource.data))
                    }
                    is Resource.Error -> {
                        updateMovieDetailStates(movieId, MovieDetailState.Error(resource.message))
                    }
                }
            }
        }
    }

    private fun updateMovieDetailStates(movieId: Int, movieDetailState: MovieDetailState) {
        val currentMap = _moviesDetailStates.value.toMutableMap()
        currentMap[movieId] = movieDetailState
        _moviesDetailStates.value = currentMap
    }
}