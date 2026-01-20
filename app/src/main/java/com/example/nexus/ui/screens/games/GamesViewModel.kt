package com.example.nexus.ui.screens.games

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nexus.common.constants.MoviesGenreIds
import com.example.nexus.common.constants.NetworkConstants
import com.example.nexus.common.core.Resource
import com.example.nexus.domain.model.Movie
import com.example.nexus.domain.model.Serie
import com.example.nexus.domain.usecase.movies.MoviesUseCase
import com.example.nexus.domain.usecase.series.SeriesUseCase
import com.example.nexus.ui.screens.movies.MoviesState
import com.example.nexus.ui.screens.series.SeriesState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class GamesViewModel(
    private val moviesUseCase: MoviesUseCase,
    private val seriesUseCase: SeriesUseCase
) : ViewModel() {

    private val _featuredMoviesState = MutableStateFlow<MoviesState>(MoviesState.Loading)
    val featuredMoviesState: StateFlow<MoviesState> = _featuredMoviesState.asStateFlow()

    private val _gamesUiState = MutableStateFlow(GamesUiState())
    val gamesUiState: StateFlow<GamesUiState> = _gamesUiState.asStateFlow()

    private val _gamesState = MutableStateFlow<MoviesState>(MoviesState.Loading)
    val gamesState: StateFlow<MoviesState> = _gamesState.asStateFlow()

    private val _gamesTop10State = MutableStateFlow<MoviesState>(MoviesState.Loading)
    val gamesTop10State: StateFlow<MoviesState> = _gamesTop10State.asStateFlow()

    init {
        loadFeaturedMovies()
        loadGamesPopular()
        loadTop10Games()
        loadGamesContent()
    }

    private fun loadFeaturedMovies() {
        viewModelScope.launch {
            moviesUseCase.discoverMovies.invoke(
                genreId = MoviesGenreIds.ANIMATION,
                page = 1,
                originCountry = NetworkConstants.ORIGIN_COUNTRY_US).collect { resource ->
                _featuredMoviesState.value = when (resource) {
                    is Resource.Loading -> MoviesState.Loading
                    is Resource.Success -> MoviesState.Success(resource.data)
                    is Resource.Error -> MoviesState.Error(resource.message)
                }
            }
        }
    }

    private fun loadGamesPopular(page: Int = 1) {
        viewModelScope.launch {
            moviesUseCase.discoverMovies.invoke(
                genreId = MoviesGenreIds.ANIMATION,
                page = page,
                originCountry = NetworkConstants.ORIGIN_COUNTRY_US).collect { resource ->
                _gamesState.value = when (resource) {
                    is Resource.Loading -> MoviesState.Loading
                    is Resource.Success -> MoviesState.Success(resource.data)
                    is Resource.Error -> MoviesState.Error(resource.message)
                }
            }
        }
    }

    private fun loadTop10Games(page: Int = 2) {
        viewModelScope.launch {
            moviesUseCase.discoverMovies.invoke(
                genreId = MoviesGenreIds.ANIMATION,
                page = page,
                originCountry = NetworkConstants.ORIGIN_COUNTRY_US).collect { resource ->
                _gamesTop10State.value = when (resource) {
                    is Resource.Loading -> MoviesState.Loading
                    is Resource.Success -> MoviesState.Success(resource.data)
                    is Resource.Error -> MoviesState.Error(resource.message)
                }
            }
        }
    }

    private fun loadGamesContent() {
        GamesCategories.gamesCategories.forEach { category ->
            when (category) {
                is GameMovieCategory -> { loadMoviesContent(category) }
                is GameSerieCategory -> { loadSeriesContent(category) }
            }
        }
    }

    private fun loadMoviesContent(category: GameMovieCategory) {
        discoverMovies(category)
    }

    private fun discoverMovies(category: GameMovieCategory) {
        val genreId = category.genreId ?: return
        viewModelScope.launch {
            moviesUseCase.discoverMovies.invoke(genreId, category.page, category.originCountry).collect { resource ->
                updateMoviesUiState(category, resource)
            }
        }
    }

    private fun updateMoviesUiState(category: GameMovieCategory, resource: Resource<List<Movie>>) {
        _gamesUiState.update { currentUiState ->
            val updateMoviesMap = currentUiState.moviesMap.toMutableMap()
            updateMoviesMap[category] = when (resource) {
                is Resource.Loading -> MoviesState.Loading
                is Resource.Success -> MoviesState.Success(resource.data)
                is Resource.Error -> MoviesState.Error(resource.message)
            }
            currentUiState.copy(moviesMap = updateMoviesMap)
        }
    }

    private fun loadSeriesContent(category: GameSerieCategory) {
        discoverSeries(category)
    }

    private fun discoverSeries(category: GameSerieCategory) {
        val genreId = category.genreId ?: return
        viewModelScope.launch {
            seriesUseCase.discoverSeries.invoke(genreId, category.page, category.originCountry).collect { resource ->
                updateSeriesUiState(category, resource)
            }
        }
    }

    private fun updateSeriesUiState(category: GameSerieCategory, resource: Resource<List<Serie>>) {
        _gamesUiState.update { currentUiState ->
            val updateSeriesMap = currentUiState.seriesMap.toMutableMap()
            updateSeriesMap[category] = when (resource) {
                is Resource.Loading -> SeriesState.Loading
                is Resource.Success -> SeriesState.Success(resource.data)
                is Resource.Error -> SeriesState.Error(resource.message)
            }
            currentUiState.copy(seriesMap = updateSeriesMap)
        }
    }
}