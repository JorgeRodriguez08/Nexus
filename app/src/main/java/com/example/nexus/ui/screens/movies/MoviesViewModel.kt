package com.example.nexus.ui.screens.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nexus.common.Resource
import com.example.nexus.domain.models.Movie
import com.example.nexus.domain.usecase.movies.MoviesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.collections.toMutableMap

class MoviesViewModel(
    private val moviesUseCase: MoviesUseCase
): ViewModel() {

    private val _moviesUiState = MutableStateFlow(MoviesUiState())
    val moviesUiState: StateFlow<MoviesUiState> = _moviesUiState.asStateFlow()

    private val _featuredMoviesState = MutableStateFlow<MoviesState>(MoviesState.Loading)
    val featuredMoviesState: StateFlow<MoviesState> = _featuredMoviesState.asStateFlow()

    val moviesCategories = MoviesCategories.moviesCategories

    fun loadMoviesContent() {
        moviesCategories.forEach { category ->
            when (category) {
                is MovieCategory.Trending -> loadMoviesTrending(category)
                is MovieCategory.NowPlaying -> loadMoviesNowPlaying(category, 1)
                is MovieCategory.UpComing -> loadMoviesUpComing(category, 1)
                is MovieCategory.Popular -> loadMoviesPopular(category, 1)
                else -> discoverMovies(category)
            }
        }
    }

    fun loadFeaturedMovies() {
        viewModelScope.launch {
            moviesUseCase.getMoviesTrending.invoke().collect { resource ->
                _featuredMoviesState.value = when (resource) {
                    is Resource.Loading -> MoviesState.Loading
                    is Resource.Success -> MoviesState.Success(resource.data)
                    is Resource.Error -> MoviesState.Error(resource.message)
                }
            }
        }
    }

    private fun loadMoviesTrending(category: MovieCategory) {
        viewModelScope.launch(Dispatchers.IO) {
            moviesUseCase.getMoviesTrending.invoke().collect { resource ->
                updateMoviesUiState(category, resource)
            }
        }
    }

    private fun loadMoviesNowPlaying(category: MovieCategory, page: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            moviesUseCase.getMoviesNowPlaying.invoke(page).collect { resource ->
                updateMoviesUiState(category, resource)
            }
        }
    }

    private fun loadMoviesUpComing(category: MovieCategory, page: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            moviesUseCase.getMoviesUpComing.invoke(page).collect { resource ->
                updateMoviesUiState(category, resource)
            }
        }
    }

    private fun loadMoviesPopular(category: MovieCategory, page: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            moviesUseCase.getMoviesPopular.invoke(page).collect { resource ->
                updateMoviesUiState(category, resource)
            }
        }
    }

    private fun discoverMovies(category: MovieCategory) {
        val genreId = category.genreId ?: return
        viewModelScope.launch(Dispatchers.IO) {
            moviesUseCase.discoverMovies.invoke(genreId, category.page, category.originCountry).collect { resource ->
                updateMoviesUiState(category, resource)
            }
        }
    }

    private fun updateMoviesUiState(category: MovieCategory, resource: Resource<List<Movie>>) {
        _moviesUiState.update { currentUiState ->
            val updateMoviesMap = currentUiState.moviesMap.toMutableMap()
            updateMoviesMap[category] = when (resource) {
                is Resource.Loading -> MoviesState.Loading
                is Resource.Success -> MoviesState.Success(resource.data)
                is Resource.Error -> MoviesState.Error(resource.message)
            }
            currentUiState.copy(moviesMap = updateMoviesMap)
        }
    }
}