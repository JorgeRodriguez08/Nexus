package com.example.nexus.ui.screens.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nexus.common.core.Resource
import com.example.nexus.common.constants.MoviesGenreIds
import com.example.nexus.common.constants.NetworkConstants
import com.example.nexus.domain.usecase.movies.MoviesUseCase
import com.example.nexus.ui.screens.movies.MoviesState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SearchViewModel(
    private val moviesUseCase: MoviesUseCase
) : ViewModel() {

    private val _value: MutableStateFlow<String> = MutableStateFlow("")
    val value: StateFlow<String> = _value.asStateFlow()

    private val _searchResultsState = MutableStateFlow<MoviesState>(MoviesState.Loading)
    val searchResultsState: StateFlow<MoviesState> = _searchResultsState.asStateFlow()

    private val _gamesUiState = MutableStateFlow<MoviesState>(MoviesState.Loading)
    val gamesUiState: StateFlow<MoviesState> = _gamesUiState.asStateFlow()

    private val _moviesUiState = MutableStateFlow<MoviesState>(MoviesState.Loading)
    val moviesUiState: StateFlow<MoviesState> = _moviesUiState.asStateFlow()

    fun loadGamesPopular(page: Int = 1) {
        viewModelScope.launch(Dispatchers.IO) {
            moviesUseCase.discoverMovies.invoke(MoviesGenreIds.ANIMATION, page, NetworkConstants.ORIGINAL_COUNTRY_US).collect { resource ->
                _gamesUiState.value = when (resource) {
                    is Resource.Loading -> MoviesState.Loading
                    is Resource.Success -> MoviesState.Success(resource.data)
                    is Resource.Error -> MoviesState.Error(resource.message)
                }
            }
        }
    }

    fun loadMoviesPopular(page: Int = 1) {
        viewModelScope.launch(Dispatchers.IO) {
            moviesUseCase.getMoviesPopular.invoke(page).collect { resource ->
                _moviesUiState.value = when (resource) {
                    is Resource.Loading -> MoviesState.Loading
                    is Resource.Success -> MoviesState.Success(resource.data)
                    is Resource.Error -> MoviesState.Error(resource.message)
                }
            }
        }
    }

    fun onValueChange(newValue: String) {
        _value.value = newValue
        searchResults(newValue)
    }

    fun searchResults(query: String, page: Int = 1) {
        viewModelScope.launch(Dispatchers.IO) {
            moviesUseCase.searchMovie.invoke(query, page).collect { resource ->
                _searchResultsState.value = when (resource) {
                    is Resource.Loading -> MoviesState.Loading
                    is Resource.Success -> MoviesState.Success(resource.data)
                    is Resource.Error -> MoviesState.Error(resource.message)
                }
            }
        }
    }
}