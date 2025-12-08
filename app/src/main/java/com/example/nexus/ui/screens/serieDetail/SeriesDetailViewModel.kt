package com.example.nexus.ui.screens.serieDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nexus.common.Resource
import com.example.nexus.domain.models.Serie
import com.example.nexus.domain.usecase.series.SeriesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SeriesDetailViewModel(
    private val seriesUseCase: SeriesUseCase
) : ViewModel() {

    private val _seriesDetailState = MutableStateFlow<SerieDetailsState<Serie>>(SerieDetailsState.Loading)
    val seriesDetailState: StateFlow<SerieDetailsState<Serie>> = _seriesDetailState.asStateFlow()

    fun loadSeriesDetail(page: Int = 1, seriesId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            delay(50)
            seriesUseCase.getSerieDetails.invoke(seriesId).collect { resource ->
                _seriesDetailState.value = when (resource) {
                    is Resource.Loading -> SerieDetailsState.Loading
                    is Resource.Success -> SerieDetailsState.Success(resource.data)
                    is Resource.Error -> SerieDetailsState.Error(resource.message)
                }
            }
        }
    }
}