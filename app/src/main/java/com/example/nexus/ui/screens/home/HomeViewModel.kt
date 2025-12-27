package com.example.nexus.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nexus.common.core.Resource
import com.example.nexus.domain.model.Movie
import com.example.nexus.domain.model.Serie
import com.example.nexus.domain.usecase.movies.MoviesUseCase
import com.example.nexus.domain.usecase.series.SeriesUseCase
import com.example.nexus.ui.screens.movies.MovieCategory
import com.example.nexus.ui.screens.movies.MoviesState
import com.example.nexus.ui.screens.series.SerieCategory
import com.example.nexus.ui.screens.series.SeriesState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val moviesUseCase: MoviesUseCase,
    private val seriesUseCase: SeriesUseCase
) : ViewModel() {

    private val _featuredMoviesState = MutableStateFlow<MoviesState>(MoviesState.Loading)
    val featuredMoviesState: StateFlow<MoviesState> = _featuredMoviesState.asStateFlow()

    private val _homeUiState = MutableStateFlow(HomeUiState())
    val homeUiState: StateFlow<HomeUiState> = _homeUiState.asStateFlow()

    init {
        loadFeaturedMovies()
        loadHomeContent()
    }

    private fun loadFeaturedMovies() {
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

    private fun loadHomeContent() {
        HomeCategories.homeCategories.forEach { category ->
            when (category) {
                is MovieCategory -> { loadMoviesContent(category) }
                is SerieCategory -> { loadSeriesContent(category) }
            }
        }
    }

    private fun loadMoviesContent(category: MovieCategory) {
        when (category) {
            is MovieCategory.Trending -> loadMoviesTrending(category)
            is MovieCategory.NowPlaying -> loadMoviesNowPlaying(category, 1)
            is MovieCategory.UpComing -> loadMoviesUpComing(category, 1)
            is MovieCategory.Popular -> loadMoviesPopular(category, 1)
            else -> discoverMovies(category)
        }
    }

    private fun loadMoviesTrending(category: MovieCategory) {
        viewModelScope.launch {
            moviesUseCase.getMoviesTrending.invoke().collect { resource ->
                updateMoviesUiState(category, resource)
            }
        }
    }

    private fun loadMoviesNowPlaying(category: MovieCategory, page: Int) {
        viewModelScope.launch {
            moviesUseCase.getMoviesNowPlaying.invoke(page).collect { resource ->
                updateMoviesUiState(category, resource)
            }
        }
    }

    private fun loadMoviesUpComing(category: MovieCategory, page: Int) {
        viewModelScope.launch {
            moviesUseCase.getMoviesUpComing.invoke(page).collect { resource ->
                updateMoviesUiState(category, resource)
            }
        }
    }

    private fun loadMoviesPopular(category: MovieCategory, page: Int) {
        viewModelScope.launch {
            moviesUseCase.getMoviesPopular.invoke(page).collect { resource ->
                updateMoviesUiState(category, resource)
            }
        }
    }

    private fun discoverMovies(category: MovieCategory) {
        val genreId = category.genreId ?: return
        viewModelScope.launch {
            moviesUseCase.discoverMovies.invoke(genreId, category.page, category.originCountry).collect { resource ->
                updateMoviesUiState(category, resource)
            }
        }
    }

    private fun updateMoviesUiState(category: MovieCategory, resource: Resource<List<Movie>>) {
        _homeUiState.update { currentUiState ->
            val updateMoviesMap = currentUiState.moviesMap.toMutableMap()
            updateMoviesMap[category] = when (resource) {
                is Resource.Loading -> MoviesState.Loading
                is Resource.Success -> MoviesState.Success(resource.data)
                is Resource.Error -> MoviesState.Error(resource.message)
            }
            currentUiState.copy(moviesMap = updateMoviesMap)
        }
    }

    private fun loadSeriesContent(category: SerieCategory) {
        when (category) {
            is SerieCategory.Trending -> loadSeriesTrending(category)
            is SerieCategory.AiringToday -> loadSeriesAiringToday(category, 1)
            is SerieCategory.OnTheAir -> loadSeriesOnTheAir(category, 1)
            is SerieCategory.Popular -> loadSeriesPopular(category, 1)
            else -> discoverSeries(category)
        }
    }

    private fun loadSeriesTrending(category: SerieCategory) {
        viewModelScope.launch {
            seriesUseCase.getSeriesTrending.invoke().collect { resource ->
                updateSeriesUiState(category, resource)
            }
        }
    }

    private fun loadSeriesAiringToday(category: SerieCategory, page: Int) {
        viewModelScope.launch {
            seriesUseCase.getSeriesAiringToday.invoke(page).collect { resource ->
                updateSeriesUiState(category, resource)
            }
        }
    }

    private fun loadSeriesOnTheAir(category: SerieCategory, page: Int) {
        viewModelScope.launch {
            seriesUseCase.getSeriesOnTheAir.invoke(page).collect { resource ->
                updateSeriesUiState(category, resource)
            }
        }
    }

    private fun loadSeriesPopular(category: SerieCategory, page: Int) {
        viewModelScope.launch {
            seriesUseCase.getSeriesPopular.invoke(page).collect { resource ->
                updateSeriesUiState(category, resource)
            }
        }
    }

    private fun discoverSeries(category: SerieCategory) {
        val genreId = category.genreId ?: return
        viewModelScope.launch {
            seriesUseCase.discoverSeries.invoke(genreId, category.page, category.originCountry).collect { resource ->
                updateSeriesUiState(category, resource)
            }
        }
    }

    private fun updateSeriesUiState(category: SerieCategory, resource: Resource<List<Serie>>) {
        _homeUiState.update { currentUiState ->
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