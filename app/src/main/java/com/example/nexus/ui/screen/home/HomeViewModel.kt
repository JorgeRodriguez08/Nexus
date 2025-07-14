package com.example.nexus.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nexus.domain.model.Movie
import com.example.nexus.domain.model.Series
import com.example.nexus.domain.usecase.GetMovieByIdUseCase
import com.example.nexus.domain.usecase.GetMoviesByGenreUseCase
import com.example.nexus.domain.usecase.GetMoviesUseCase
import com.example.nexus.domain.usecase.SearchMoviesUseCase
import com.example.nexus.domain.usecase.GetSeriesByGenreUseCase
import com.example.nexus.domain.usecase.GetSeriesByIdUseCase
import com.example.nexus.domain.usecase.GetSeriesUseCase
import com.example.nexus.domain.usecase.SearchSeriesUseCase
import com.example.nexus.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class HomeViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val getMovieByIdUseCase: GetMovieByIdUseCase,
    private val getMoviesByGenreUseCase: GetMoviesByGenreUseCase,
    private val searchMoviesUseCase: SearchMoviesUseCase,
    private val getSeriesUseCase: GetSeriesUseCase,
    private val getSeriesByIdUseCase: GetSeriesByIdUseCase,
    private val getSeriesByGenreUseCase: GetSeriesByGenreUseCase,
    private val searchSeriesUseCase: SearchSeriesUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    private val _featuredMovie = MutableStateFlow<Movie?>(null)
    val featuredMovie: StateFlow<Movie?> = _featuredMovie.asStateFlow()

    init {
        loadHomeContent()
    }

    private fun loadHomeContent() {
        homeCategories.forEach { category ->
           if (category.isMovie) {
               val fetchMovie: suspend () -> Flow<Resource<List<Movie>>> = {
                   category.genreId?.let { getMoviesByGenreUseCase(it, "en", 1) }
                       ?: getMoviesUseCase(1)
               }
               loadMovieCategory(category, fetchMovie)
           } else if (category.isSeries) {
                val fetchSeries: suspend () -> Flow<Resource<List<Series>>> = {
                    category.genreId?.let { getSeriesByGenreUseCase(it, "en", 1) }
                        ?: getSeriesUseCase(1)
                }
               loadSeriesCategory(category, fetchSeries)
           }


        }
    }

    private fun loadMovieCategory(
        category: HomeCategory,
        fetch: suspend () -> Flow<Resource<List<Movie>>>
    ) {
        viewModelScope.launch {
            fetch().collect { result ->
                val currentMap = _uiState.value.movieState.toMutableMap()
                currentMap[category] = when (result) {
                    is Resource.Loading -> CategoryUiState(isLoading = true)
                    is Resource.Success -> {
                        val items = result.data ?: emptyList()
                        if (_featuredMovie.value == null && items.isNotEmpty()) {
                            _featuredMovie.value = items.first()
                        }
                        CategoryUiState(items = items)
                    }
                    is Resource.Error -> CategoryUiState(error = result.message)
                }
                _uiState.update { it.copy(movieState = currentMap) }
            }
        }
    }

    private fun loadSeriesCategory(
        category: HomeCategory,
        fetch: suspend () -> Flow<Resource<List<Series>>>
    ) {
        viewModelScope.launch {
            fetch().collect { result ->
                val currentMap = _uiState.value.seriesState.toMutableMap()
                currentMap[category] = when (result) {
                    is Resource.Loading -> CategoryUiState(isLoading = true)
                    is Resource.Success -> CategoryUiState(items = result.data ?: emptyList())
                    is Resource.Error -> CategoryUiState(error = result.message)
                }
                _uiState.update { it.copy(seriesState = currentMap) }
            }
        }
    }

}

