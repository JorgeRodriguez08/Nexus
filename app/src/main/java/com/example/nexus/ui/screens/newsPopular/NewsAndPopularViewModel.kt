package com.example.nexus.ui.screens.newsPopular

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nexus.common.Resource
import com.example.nexus.constants.MovieGenreId
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

    private val _moviesDetailStates = MutableStateFlow<Map<Int, MovieMultimediaState>>(emptyMap())
    val moviesDetailStates: StateFlow<Map<Int, MovieMultimediaState>> = _moviesDetailStates.asStateFlow()

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
                when (resource) {
                    is Resource.Loading -> {
                        _moviesUiState.value = MoviesState.Loading
                    }
                    is Resource.Success -> {
                        _moviesUiState.value = MoviesState.Success(resource.data)
                        resource.data.forEach { movie -> loadMovieMultimedia(movie.id) }
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
                        resource.data.forEach { movie -> loadMovieMultimedia(movie.id) }
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
            moviesUseCase.discoverMovies.invoke(MovieGenreId.ANIMATION, page).collect { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        _moviesUiState.value = MoviesState.Loading
                    }
                    is Resource.Success -> {
                        _moviesUiState.value = MoviesState.Success(resource.data)
                        resource.data.forEach { movie -> loadMovieMultimedia(movie.id) }
                    }
                    is Resource.Error -> {
                        _moviesUiState.value = MoviesState.Error(resource.message)
                    }
                }
            }
        }
    }

    fun loadTop10Series(page: Int = 1) {

    }

    fun loadTop10Movies(page: Int = 1) {
        viewModelScope.launch(Dispatchers.IO) {
            moviesUseCase.getMoviesTopRated.invoke(page).collect { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        _moviesUiState.value = MoviesState.Loading
                    }
                    is Resource.Success -> {
                        _moviesUiState.value = MoviesState.Success(resource.data)
                        resource.data.forEach { movie -> loadMovieMultimedia(movie.id) }
                    }
                    is Resource.Error -> {
                        _moviesUiState.value = MoviesState.Error(resource.message)
                    }
                }
            }
        }
    }

    fun loadMovieMultimedia(movieId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            updateMovieDetailState(movieId, MovieMultimediaState.Loading)

            moviesUseCase.getMovieMultimedia.invoke(movieId).collect { resource ->
                when (resource) {
                    is Resource.Loading -> updateMovieDetailState(movieId, MovieMultimediaState.Loading)
                    is Resource.Success -> updateMovieDetailState(movieId, MovieMultimediaState.Success(resource.data))
                    is Resource.Error -> updateMovieDetailState(movieId, MovieMultimediaState.Error(resource.message))
                }
            }
        }
    }

    private fun updateMovieDetailState(movieId: Int, state: MovieMultimediaState) {
        val currentMap = _moviesDetailStates.value.toMutableMap()
        currentMap[movieId] = state
        _moviesDetailStates.value = currentMap
    }
    
}