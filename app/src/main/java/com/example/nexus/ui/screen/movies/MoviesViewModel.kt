package com.example.nexus.ui.screen.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nexus.common.Resource
import com.example.nexus.domain.model.Movie
import com.example.nexus.domain.usecase.movies.MoviesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MoviesViewModel(
    private val moviesUseCase: MoviesUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(MoviesUiState())
    val uiState: StateFlow<MoviesUiState> = _uiState.asStateFlow()

    private val _featuredMoviesState = MutableStateFlow<MoviesState<Movie>>(MoviesState.Loading)
    val featuredMoviesState: StateFlow<MoviesState<Movie>> = _featuredMoviesState.asStateFlow()

    val moviesCategories = MoviesCategories.moviesCategories

    init {
        loadFeaturedMovies()
        loadMoviesContent()
    }

    private fun loadMoviesContent() {
        moviesCategories.forEach { category ->
            when (category) {
                is MoviesCategory.NowPlaying -> loadMoviesNowPlaying(category)
                is MoviesCategory.Popular -> loadMoviesPopular(category)
                is MoviesCategory.TopRated -> loadMoviesTopRated(category)
                is MoviesCategory.UpComing -> loadMoviesUpComing(category)
                else -> loadMoviesByGenre(category)
            }

        }
    }
    private fun loadFeaturedMovies(page: Int = 1) {
        viewModelScope.launch {
            moviesUseCase.getMoviesNowPlaying.invoke(page).collect { resource ->
                _featuredMoviesState.value = when (resource) {
                    is Resource.Loading -> MoviesState.Loading
                    is Resource.Success -> MoviesState.Success(resource.data)
                    is Resource.Error -> MoviesState.Error(resource.message)
                }
            }
        }
    }

    private fun loadMoviesNowPlaying(category: MoviesCategory, page: Int = 1) {
        viewModelScope.launch {
            moviesUseCase.getMoviesNowPlaying.invoke(page).collect { resource ->
                updateUiState(category, resource)
            }
        }
    }

    private fun loadMoviesPopular(category: MoviesCategory, page: Int = 1) {
        viewModelScope.launch {
            moviesUseCase.getMoviesPopular.invoke(page).collect { resource ->
                updateUiState(category, resource)
            }
        }
    }

    private fun loadMoviesTopRated(category: MoviesCategory, page: Int = 1) {
        viewModelScope.launch {
            moviesUseCase.getMoviesTopRated.invoke(page).collect { resource ->
                updateUiState(category, resource)
            }
        }
    }

    private fun loadMoviesUpComing(category: MoviesCategory, page: Int = 1) {
        viewModelScope.launch {
            moviesUseCase.getMoviesUpComing.invoke(page).collect { resource ->
                updateUiState(category, resource)
            }
        }
    }

    private fun loadMoviesByGenre(category: MoviesCategory, page: Int = 1) {
        val genreId = category.genreId ?: return
        viewModelScope.launch {
            moviesUseCase.getMoviesByGenre.invoke(genreId, page).collect { resource ->
                updateUiState(category, resource)
            }
        }
    }

    private fun updateUiState(category: MoviesCategory, resource: Resource<List<Movie>>) {
        _uiState.update { currentUiState ->
            val updateMoviesUiState = currentUiState.moviesUiState.toMutableMap()
            updateMoviesUiState[category] = when (resource) {
                is Resource.Loading -> MoviesState.Loading
                is Resource.Success -> MoviesState.Success(resource.data)
                is Resource.Error -> MoviesState.Error(resource.message)
            }
            currentUiState.copy(updateMoviesUiState)
        }
    }
}