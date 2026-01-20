package com.example.nexus.ui.screens.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nexus.common.core.Resource
import com.example.nexus.common.constants.MoviesGenreIds
import com.example.nexus.common.constants.NetworkConstants
import com.example.nexus.domain.usecase.movies.MoviesUseCase
import com.example.nexus.domain.usecase.series.SeriesUseCase
import com.example.nexus.ui.screens.movies.MoviesState
import com.example.nexus.ui.screens.series.SeriesState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SearchViewModel(
    private val moviesUseCase: MoviesUseCase,
    private val seriesUseCase: SeriesUseCase
) : ViewModel() {

    private val _query: MutableStateFlow<String> = MutableStateFlow("")
    val value: StateFlow<String> = _query.asStateFlow()

    private val _searchMovieState = MutableStateFlow<MoviesState>(MoviesState.Loading)
    val searchMovieState: StateFlow<MoviesState> = _searchMovieState.asStateFlow()

    private val _searchSerieState = MutableStateFlow<SeriesState>(SeriesState.Loading)
    val searchSerieState: StateFlow<SeriesState> = _searchSerieState.asStateFlow()

    private val _gamesState = MutableStateFlow<MoviesState>(MoviesState.Loading)
    val gamesState: StateFlow<MoviesState> = _gamesState.asStateFlow()

    private val _moviesState = MutableStateFlow<MoviesState>(MoviesState.Loading)
    val moviesState: StateFlow<MoviesState> = _moviesState.asStateFlow()

    private val _seriesState = MutableStateFlow<SeriesState>(SeriesState.Loading)
    val seriesState: StateFlow<SeriesState> = _seriesState.asStateFlow()

    init {
        loadGamesPopular()
        loadMoviesPopular()
        loadSeriesPopular()
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

    private fun loadMoviesPopular(page: Int = 1) {
        viewModelScope.launch {
            moviesUseCase.getMoviesPopular.invoke(page).collect { resource ->
                _moviesState.value = when (resource) {
                    is Resource.Loading -> MoviesState.Loading
                    is Resource.Success -> MoviesState.Success(resource.data)
                    is Resource.Error -> MoviesState.Error(resource.message)
                }
            }
        }
    }

    private fun loadSeriesPopular(page: Int = 1) {
        viewModelScope.launch {
            seriesUseCase.getSeriesPopular.invoke(page).collect { resource ->
                _seriesState.value = when (resource) {
                    is Resource.Loading -> SeriesState.Loading
                    is Resource.Success -> SeriesState.Success(resource.data)
                    is Resource.Error -> SeriesState.Error(resource.message)
                }
            }
        }
    }

    fun onValueChange(newQuery: String) {
        _query.value = newQuery
        searchMoviesResults(newQuery)
        searchSeriesResults(newQuery)
    }

    private fun searchMoviesResults(query: String, page: Int = 1) {
        viewModelScope.launch {
            moviesUseCase.searchMovie.invoke(query, page).collect { resource ->
                _searchMovieState.value = when (resource) {
                    is Resource.Loading -> MoviesState.Loading
                    is Resource.Success -> MoviesState.Success(resource.data)
                    is Resource.Error -> MoviesState.Error(resource.message)
                }
            }
        }
    }

    private fun searchSeriesResults(query: String, page: Int = 1) {
        viewModelScope.launch {
            seriesUseCase.searchSerie.invoke(query, page).collect { resource ->
                _searchSerieState.value = when (resource) {
                    is Resource.Loading -> SeriesState.Loading
                    is Resource.Success -> SeriesState.Success(resource.data)
                    is Resource.Error -> SeriesState.Error(resource.message)
                }
            }

        }
    }
}