package com.example.nexus.ui.screens.series

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nexus.common.Resource
import com.example.nexus.domain.model.Series
import com.example.nexus.domain.usecase.series.SeriesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay

class SeriesViewModel(
    private val seriesUseCase: SeriesUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(SeriesUiState())
    val uiState: StateFlow<SeriesUiState> = _uiState.asStateFlow()

    private val _featuredSeriesState = MutableStateFlow<SeriesState<Series>>(SeriesState.Loading)
    val featuredSeriesState: StateFlow<SeriesState<Series>> = _featuredSeriesState.asStateFlow()

    val seriesCategories = SeriesCategories.seriesCategories

    fun loadSeriesContent() {
        seriesCategories.forEach { category ->
            when (category) {
                is SeriesCategory.AiringToday -> loadSeriesAiringToday(category, 1)
                is SeriesCategory.OnTheAir -> loadSeriesOnTheAir(category, 1)
                is SeriesCategory.Popular -> loadSeriesPopular(category, 1)
                is SeriesCategory.TopRated -> loadSeriesTopRated(category, 1)
                else -> loadSeriesByGenre(category, 1)
            }
        }
    }

    fun loadFeaturedSeries(page: Int = 1) {
        viewModelScope.launch(Dispatchers.IO) {
            delay(50)
            seriesUseCase.getSeriesAiringToday.invoke(page).collect { resource ->
                _featuredSeriesState.value = when (resource) {
                    is Resource.Loading -> SeriesState.Loading
                    is Resource.Success -> SeriesState.Success(resource.data)
                    is Resource.Error -> SeriesState.Error(resource.message)
                }
            }
        }
    }

    private fun loadSeriesAiringToday(category: SeriesCategory, page: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            delay(50)
            seriesUseCase.getSeriesAiringToday.invoke(page).collect { resource ->
                updateUiState(category, resource)
            }
        }
    }

    private fun loadSeriesOnTheAir(category: SeriesCategory, page: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            delay(50)
            seriesUseCase.getSeriesOnTheAir.invoke(page).collect { resource ->
                updateUiState(category, resource)
            }
        }
    }

    private fun loadSeriesPopular(category: SeriesCategory, page: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            delay(50)
            seriesUseCase.getSeriesPopular.invoke(page).collect { resource ->
                updateUiState(category, resource)
            }
        }
    }

    private fun loadSeriesTopRated(category: SeriesCategory, page: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            delay(50)
            seriesUseCase.getSeriesTopRated.invoke(page).collect { resource ->
                updateUiState(category, resource)
            }
        }
    }

    private fun loadSeriesByGenre(category: SeriesCategory, page: Int) {
        val genreId = category.genreId ?: return
        viewModelScope.launch(Dispatchers.IO) {
            delay(100)
            seriesUseCase.getSeriesByGenre.invoke(genreId, page).collect { resource ->
                updateUiState(category, resource)
            }
        }
    }

    private fun updateUiState(category: SeriesCategory, resource: Resource<List<Series>>) {
        _uiState.update { currentUiState ->
            val updateSeriesUiState = currentUiState.seriesUiState.toMutableMap()
            updateSeriesUiState[category] = when (resource) {
                is Resource.Loading -> SeriesState.Loading
                is Resource.Success -> SeriesState.Success(items = resource.data)
                is Resource.Error -> SeriesState.Error(message = resource.message)
            }
            currentUiState.copy(seriesUiState = updateSeriesUiState)
        }
    }
}