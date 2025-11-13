package com.example.nexus.ui.screens.games

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nexus.common.Resource
import com.example.nexus.domain.model.Movie
import com.example.nexus.domain.model.Series
import com.example.nexus.domain.usecase.movies.MoviesUseCase
import com.example.nexus.domain.usecase.series.SeriesUseCase
import com.example.nexus.ui.screens.movies.MoviesCategory
import com.example.nexus.ui.screens.movies.MoviesState
import com.example.nexus.ui.screens.series.SeriesCategory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class GamesViewModel(
    private val moviesUseCase: MoviesUseCase,
    private val seriesUseCase: SeriesUseCase
) : ViewModel() {

    private val _gamesUiState = MutableStateFlow(GamesUiState(rows = GamesCategories.rows))
    val gamesUiState: StateFlow<GamesUiState> = _gamesUiState.asStateFlow()

    private val _featuredState = MutableStateFlow<MoviesState>(MoviesState.Loading)
    val featuredState: StateFlow<MoviesState> = _featuredState.asStateFlow()

    fun loadGamesContent() {
        GamesCategories.rows.forEach { row ->
            when (row) {
                is GamesRow.MoviesRow -> loadMoviesRow(row.category, 1)
                is GamesRow.SeriesRow -> loadSeriesRow(row.category, 1)
            }
        }
    }

    fun loadFeaturedMovies(page: Int = 1) {
        viewModelScope.launch {
            delay(50)
            moviesUseCase.getMoviesUpComing.invoke(page).collect { resource ->
                _featuredState.value = when (resource) {
                    is Resource.Loading -> MoviesState.Loading
                    is Resource.Success -> MoviesState.Success(resource.data)
                    is Resource.Error -> MoviesState.Error(resource.message)
                }
            }
        }
    }

    private fun loadMoviesRow(category: MoviesCategory, page: Int) {
        when (category) {
            is MoviesCategory.NowPlaying -> loadMoviesNowPlaying(category, 1)
            is MoviesCategory.Popular -> loadMoviesPopular(category, 1)
            is MoviesCategory.TopRated -> loadMoviesTopRated(category, 1)
            is MoviesCategory.UpComing -> loadMoviesUpComing(category, 1)
            else -> loadMoviesByGenre(category, 1)
        }
    }

    private fun loadSeriesRow(category: SeriesCategory, page: Int) {
        when (category) {
            is SeriesCategory.AiringToday -> loadSeriesAiringToday(category, 1)
            is SeriesCategory.OnTheAir -> loadSeriesOnTheAir(category, 1)
            is SeriesCategory.Popular -> loadSeriesPopular(category, 1)
            is SeriesCategory.TopRated -> loadSeriesTopRated(category, 1)
            else -> loadSeriesByGenre(category, 1)
        }
    }

    private fun loadMoviesNowPlaying(category: MoviesCategory, page: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            delay(50)
            moviesUseCase.getMoviesNowPlaying.invoke(page).collect { resource ->
                updateMoviesState(category, resource)
            }
        }
    }

    private fun loadMoviesPopular(category: MoviesCategory, page: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            delay(50)
            moviesUseCase.getMoviesPopular.invoke(page).collect { resource ->
                updateMoviesState(category, resource)
            }
        }
    }

    private fun loadMoviesTopRated(category: MoviesCategory, page: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            delay(50)
            moviesUseCase.getMoviesTopRated.invoke(page).collect { resource ->
                updateMoviesState(category, resource)
            }
        }
    }

    private fun loadMoviesUpComing(category: MoviesCategory, page: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            delay(50)
            moviesUseCase.getMoviesUpComing.invoke(page).collect { resource ->
                updateMoviesState(category, resource)
            }
        }
    }

    private fun loadMoviesByGenre(category: MoviesCategory, page: Int) {
        val genreId = category.genreId ?: return
        viewModelScope.launch(Dispatchers.IO) {
            delay(100)
            moviesUseCase.getMoviesByGenre.invoke(genreId, page).collect { resource ->
                updateMoviesState(category, resource)
            }
        }
    }

    private fun updateMoviesState(category: MoviesCategory, resource: Resource<List<Movie>>) {
        _gamesUiState.update { currentUiState ->
            val moviesMap = currentUiState.moviesMap.toMutableMap()
            moviesMap[category] = when (resource) {
                is Resource.Loading -> GamesState.Loading
                is Resource.Success -> GamesState.Success(resource.data)
                is Resource.Error -> GamesState.Error(resource.message)
            }
            currentUiState.copy(moviesMap = moviesMap)

        }
    }

    private fun loadSeriesAiringToday(category: SeriesCategory, page: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            delay(50)
            seriesUseCase.getSeriesAiringToday.invoke(page).collect { resource ->
                updateSeriesState(category, resource)
            }
        }
    }

    private fun loadSeriesOnTheAir(category: SeriesCategory, page: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            delay(50)
            seriesUseCase.getSeriesOnTheAir.invoke(page).collect { resource ->
                updateSeriesState(category, resource)
            }
        }
    }

    private fun loadSeriesPopular(category: SeriesCategory, page: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            delay(50)
            seriesUseCase.getSeriesPopular.invoke(page).collect { resource ->
                updateSeriesState(category, resource)
            }
        }
    }

    private fun loadSeriesTopRated(category: SeriesCategory, page: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            delay(50)
            seriesUseCase.getSeriesTopRated.invoke(page).collect { resource ->
                updateSeriesState(category, resource)
            }
        }
    }

    private fun loadSeriesByGenre(category: SeriesCategory, page: Int) {
        val genreId = category.genreId ?: return
        viewModelScope.launch(Dispatchers.IO) {
            delay(50)
            seriesUseCase.getSeriesByGenre.invoke(genreId, page).collect { resource ->
                updateSeriesState(category, resource)
            }
        }
    }

    private fun updateSeriesState(category: SeriesCategory, resource: Resource<List<Series>>) {
        _gamesUiState.update { currentUiState ->
            val seriesMap = currentUiState.seriesMap.toMutableMap()
            seriesMap[category] = when (resource) {
                is Resource.Loading -> GamesState.Loading
                is Resource.Success -> GamesState.Success(items = resource.data)
                is Resource.Error -> GamesState.Error(message = resource.message)
            }
            currentUiState.copy(seriesMap = seriesMap)
        }
    }

}