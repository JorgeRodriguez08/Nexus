package com.example.nexus.ui.screens.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nexus.common.constants.NetworkConstants
import com.example.nexus.common.core.Resource
import com.example.nexus.domain.model.Movie
import com.example.nexus.domain.usecase.movies.MoviesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.collections.toMutableMap

class MoviesViewModel(
    private val moviesUseCase: MoviesUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(MoviesUiState())
    val uiState: StateFlow<MoviesUiState> = _uiState.asStateFlow()

    private val _featuredMoviesState = MutableStateFlow<MoviesState>(MoviesState.Loading)
    val featuredMoviesState: StateFlow<MoviesState> = _featuredMoviesState.asStateFlow()

    val moviesCategories = MoviesCategories.moviesCategories

    fun loadMoviesContent() {
        moviesCategories.forEach { category ->
            when (category) {
                is MoviesCategory.NowPlaying -> loadMoviesNowPlaying(category, 1)
                is MoviesCategory.Popular -> loadMoviesPopular(category, 1)
                is MoviesCategory.TopRated -> loadMoviesTopRated(category, 1)
                is MoviesCategory.UpComing -> loadMoviesUpComing(category, 1)
                else -> loadMoviesByGenre(category,1)
            }
        }
    }

    fun loadFeaturedMovies(page: Int = 1) {
        viewModelScope.launch {
            delay(50)
            moviesUseCase.getMoviesNowPlaying.invoke(page).collect { resource ->
                _featuredMoviesState.value = when (resource) {
                    is Resource.Loading -> MoviesState.Loading
                    is Resource.Success -> MoviesState.Success(resource.data)
                    is Resource.Error -> MoviesState.Error(resource.message)
                }
            }
        }
    }

    private fun loadMoviesNowPlaying(category: MoviesCategory, page: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            delay(50)
            moviesUseCase.getMoviesNowPlaying.invoke(page).collect { resource ->
                updateUiState(category, resource)
            }
        }
    }

    private fun loadMoviesPopular(category: MoviesCategory, page: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            delay(50)
            moviesUseCase.getMoviesPopular.invoke(page).collect { resource ->
                updateUiState(category, resource)
            }
        }
    }

    private fun loadMoviesTopRated(category: MoviesCategory, page: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            delay(50)
            moviesUseCase.getMoviesTopRated.invoke(page).collect { resource ->
                updateUiState(category, resource)
            }
        }
    }

    private fun loadMoviesUpComing(category: MoviesCategory, page: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            delay(50)
            moviesUseCase.getMoviesUpComing.invoke(page).collect { resource ->
                updateUiState(category, resource)
            }
        }
    }

    private fun loadMoviesByGenre(category: MoviesCategory, page: Int) {
        val genreId = category.genreId ?: return
        viewModelScope.launch(Dispatchers.IO) {
            delay(100)
            moviesUseCase.discoverMovies.invoke(genreId, page, NetworkConstants.ORIGIN_COUNTRY_US).collect { resource ->
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