package com.example.nexus.ui.screens.newsPopular

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nexus.common.constants.MoviesGenreIds
import com.example.nexus.common.constants.NetworkConstants
import com.example.nexus.common.constants.SeriesGenreIds
import com.example.nexus.common.core.Resource
import com.example.nexus.domain.usecase.movies.MoviesUseCase
import com.example.nexus.domain.usecase.series.SeriesUseCase
import com.example.nexus.ui.components.filterbar.NewsFilter
import com.example.nexus.ui.screens.movieDetails.MovieDetailsState
import com.example.nexus.ui.screens.movies.MoviesState
import com.example.nexus.ui.screens.serieDetails.SerieIntegratedState
import com.example.nexus.ui.screens.series.SeriesState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NewsViewModel(
    private val moviesUseCase: MoviesUseCase,
    private val seriesUseCase: SeriesUseCase
): ViewModel() {

    private val _selectedFilter = MutableStateFlow<NewsFilter>(NewsFilter.Upcoming)
    val selectedFilter: StateFlow<NewsFilter> = _selectedFilter.asStateFlow()

    private val _moviesState = MutableStateFlow<MoviesState>(MoviesState.Loading)
    val moviesState: StateFlow<MoviesState> = _moviesState.asStateFlow()
    private val _moviesDetailsStates = MutableStateFlow<Map<Int, MovieDetailsState>>(emptyMap())
    val moviesDetailsStates: StateFlow<Map<Int, MovieDetailsState>> = _moviesDetailsStates.asStateFlow()
    private val _seriesState = MutableStateFlow<SeriesState>(SeriesState.Loading)
    val seriesState: StateFlow<SeriesState> = _seriesState.asStateFlow()
    private val _seriesDetailsStates = MutableStateFlow<Map<Int, SerieIntegratedState>>(emptyMap())
    val seriesDetailStates: StateFlow<Map<Int, SerieIntegratedState>> = _seriesDetailsStates.asStateFlow()

    private val _upcomingState = MutableStateFlow<MoviesState>(MoviesState.Loading)
    private val _coolState = MutableStateFlow<MoviesState>(MoviesState.Loading)
    private val _mobileGamesState = MutableStateFlow<MoviesState>(MoviesState.Loading)
    private val _top10MoviesState = MutableStateFlow<MoviesState>(MoviesState.Loading)
    private val _top10SeriesState = MutableStateFlow<SeriesState>(SeriesState.Loading)

    init {
        loadAllContent()
    }

    fun setFilter(filter: NewsFilter) {
        _selectedFilter.value = filter
        when (filter) {
            NewsFilter.Upcoming -> _moviesState.value = _upcomingState.value
            NewsFilter.Cool -> _moviesState.value = _coolState.value
            NewsFilter.MobileGames -> _moviesState.value = _mobileGamesState.value
            NewsFilter.Top10Movies -> _moviesState.value = _top10MoviesState.value
            NewsFilter.Top10Series -> _seriesState.value = _top10SeriesState.value
        }
    }

    private fun loadAllContent() {
        loadMoviesUpcoming()
        loadMoviesCool()
        loadMobileGames()
        loadTop10Movies()
        loadTop10Series()
    }

    private fun loadMoviesUpcoming(page: Int = 1) {
        viewModelScope.launch {
            moviesUseCase.discoverMovies.invoke(
                genreId =
                    MoviesGenreIds.ADVENTURE + NetworkConstants.AND +
                    MoviesGenreIds.DRAMA,
                page = page,
                originCountry = NetworkConstants.ORIGINAL_COUNTRY_US
            ).collect { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        _upcomingState.value = MoviesState.Loading
                    }
                    is Resource.Success -> {
                        _upcomingState.value = MoviesState.Success(resource.data)
                        resource.data.forEach { movie -> loadMovieDetails(movie.id) }
                    }
                    is Resource.Error -> {
                        _upcomingState.value = MoviesState.Error(resource.message)
                    }
                }
            }
        }
    }

    private fun loadMoviesCool(page: Int = 1) {
        viewModelScope.launch {
            moviesUseCase.discoverMovies.invoke(
                genreId = MoviesGenreIds.THRILLER,
                page = page,
                originCountry =NetworkConstants.ORIGINAL_COUNTRY_US
            ).collect { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        _coolState.value = MoviesState.Loading
                    }
                    is Resource.Success -> {
                        _coolState.value = MoviesState.Success(resource.data)
                        resource.data.forEach { movie -> loadMovieDetails(movie.id) }
                    }
                    is Resource.Error -> {
                        _coolState.value = MoviesState.Error(resource.message)
                    }
                }
            }
        }
    }

    private fun loadMobileGames(page: Int = 1) {
        viewModelScope.launch {
            moviesUseCase.discoverMovies.invoke(
                genreId = MoviesGenreIds.ANIMATION,
                page = page,
                originCountry = NetworkConstants.ORIGINAL_COUNTRY_US
            ).collect { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        _mobileGamesState.value = MoviesState.Loading
                    }
                    is Resource.Success -> {
                        _mobileGamesState.value = MoviesState.Success(resource.data)
                        resource.data.forEach { movie -> loadMovieDetails(movie.id) }
                    }
                    is Resource.Error -> {
                        _mobileGamesState.value = MoviesState.Error(resource.message)
                    }
                }
            }
        }
    }

    private fun loadTop10Movies() {
        viewModelScope.launch {
            moviesUseCase.getMoviesTrending.invoke().collect { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        _top10MoviesState.value = MoviesState.Loading
                    }
                    is Resource.Success -> {
                        _top10MoviesState.value = MoviesState.Success(resource.data)
                        resource.data.forEach { movie -> loadMovieDetails(movie.id) }
                    }
                    is Resource.Error -> {
                        _top10MoviesState.value = MoviesState.Error(resource.message)
                    }
                }
            }
        }
    }

    private fun loadTop10Series(page: Int = 1) {
        viewModelScope.launch {
            seriesUseCase.discoverSeries.invoke(
                genreId =
                    SeriesGenreIds.ACTION_ADVENTURE + NetworkConstants.AND +
                    SeriesGenreIds.DRAMA,
                page = page,
                originCountry = NetworkConstants.ORIGINAL_COUNTRY_US
            ).collect { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        _top10SeriesState.value = SeriesState.Loading
                    }
                    is Resource.Success -> {
                        _top10SeriesState.value = SeriesState.Success(resource.data)
                        resource.data.forEach { serie -> loadSerieDetails(serie.id) }
                    }
                    is Resource.Error -> {
                        _top10SeriesState.value = SeriesState.Error(resource.message)
                    }
                }
            }
        }
    }

    private fun loadMovieDetails(movieId: Int) {
        viewModelScope.launch {
            updateMoviesDetailsStates(movieId, MovieDetailsState.Loading)
            moviesUseCase.getMovieDetails.invoke(movieId).collect { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        updateMoviesDetailsStates(movieId, MovieDetailsState.Loading)
                    }
                    is Resource.Success -> {
                        updateMoviesDetailsStates(movieId, MovieDetailsState.Success(resource.data))
                    }
                    is Resource.Error -> {
                        updateMoviesDetailsStates(movieId, MovieDetailsState.Error(resource.message))
                    }
                }
            }
        }
    }

    private fun updateMoviesDetailsStates(movieId: Int, movieDetailsState: MovieDetailsState) {
        val moviesDetailsStates = _moviesDetailsStates.value.toMutableMap()
        moviesDetailsStates[movieId] = movieDetailsState
        _moviesDetailsStates.value = moviesDetailsStates
    }

    private fun loadSerieDetails(serieId: Int) {
        viewModelScope.launch {
            seriesUseCase.getSerieIntegrated.invoke(serieId).collect { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        updateSeriesDetailsStates(serieId, SerieIntegratedState.Loading)
                    }
                    is Resource.Success -> {
                        updateSeriesDetailsStates(serieId, SerieIntegratedState.Success(resource.data))
                    }
                    is Resource.Error -> {
                        updateSeriesDetailsStates(serieId, SerieIntegratedState.Error(resource.message))
                    }
                }
            }
        }
    }

    private fun updateSeriesDetailsStates(serieId: Int, serieIntegratedState: SerieIntegratedState) {
        val seriesDetailsStates = _seriesDetailsStates.value.toMutableMap()
        seriesDetailsStates[serieId] = serieIntegratedState
        _seriesDetailsStates.value = seriesDetailsStates
    }
}