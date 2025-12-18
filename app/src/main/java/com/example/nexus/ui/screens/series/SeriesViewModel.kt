package com.example.nexus.ui.screens.series

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nexus.common.core.Resource
import com.example.nexus.domain.model.Serie
import com.example.nexus.domain.usecase.series.SeriesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SeriesViewModel(
    private val seriesUseCase: SeriesUseCase
) : ViewModel() {

    private val _seriesUiState = MutableStateFlow(SeriesUiState())
    val seriesUiState: StateFlow<SeriesUiState> = _seriesUiState.asStateFlow()

    private val _featuredSeriesState = MutableStateFlow<SeriesState>(SeriesState.Loading)
    val featuredSeriesState: StateFlow<SeriesState> = _featuredSeriesState.asStateFlow()

    val seriesCategories = SeriesCategories.seriesCategories

    fun loadSeriesContent() {
        seriesCategories.forEach { category ->
            when (category) {
                is SerieCategory.Trending -> loadSeriesTrending(category)
                is SerieCategory.AiringToday -> loadSeriesAiringToday(category, 1)
                is SerieCategory.OnTheAir -> loadSeriesOnTheAir(category, 1)
                is SerieCategory.Popular -> loadSeriesPopular(category, 1)
                else -> discoverSeries(category)
            }
        }
    }

    fun loadFeaturedSeries() {
        viewModelScope.launch(Dispatchers.IO) {
            seriesUseCase.getSeriesTrending.invoke().collect { resource ->
                _featuredSeriesState.value = when (resource) {
                    is Resource.Loading -> SeriesState.Loading
                    is Resource.Success -> SeriesState.Success(resource.data)
                    is Resource.Error -> SeriesState.Error(resource.message)
                }
            }
        }
    }

    private fun loadSeriesTrending(category: SerieCategory) {
        viewModelScope.launch(Dispatchers.IO) {
            seriesUseCase.getSeriesTrending.invoke().collect { resource ->
                updateSeriesUiState(category, resource)
            }
        }
    }

    private fun loadSeriesAiringToday(category: SerieCategory, page: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            seriesUseCase.getSeriesAiringToday.invoke(page).collect { resource ->
                updateSeriesUiState(category, resource)
            }
        }
    }

    private fun loadSeriesOnTheAir(category: SerieCategory, page: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            seriesUseCase.getSeriesOnTheAir.invoke(page).collect { resource ->
                updateSeriesUiState(category, resource)
            }
        }
    }

    private fun loadSeriesPopular(category: SerieCategory, page: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            seriesUseCase.getSeriesPopular.invoke(page).collect { resource ->
                updateSeriesUiState(category, resource)
            }
        }
    }

    private fun discoverSeries(category: SerieCategory) {
        val genreId = category.genreId ?: return
        viewModelScope.launch(Dispatchers.IO) {
            seriesUseCase.discoverSeries.invoke(genreId, category.page, category.originCountry).collect { resource ->
                updateSeriesUiState(category, resource)
            }
        }
    }

    private fun updateSeriesUiState(category: SerieCategory, resource: Resource<List<Serie>>) {
        _seriesUiState.update { currentUiState ->
            val updateSeriesMap = currentUiState.seriesMap.toMutableMap()
            updateSeriesMap[category] = when (resource) {
                is Resource.Loading -> SeriesState.Loading
                is Resource.Success -> SeriesState.Success(resource.data)
                is Resource.Error -> SeriesState.Error(resource.message)
            }
            currentUiState.copy(updateSeriesMap)
        }
    }
}