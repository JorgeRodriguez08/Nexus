package com.example.nexus.ui.screen.seriesDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nexus.common.Resource
import com.example.nexus.domain.model.Series
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

    private val _seriesDetailState = MutableStateFlow<SeriesState<Series>>(SeriesState.Loading)
    val seriesDetailState: StateFlow<SeriesState<Series>> = _seriesDetailState.asStateFlow()

    fun loadSeriesDetail(page: Int = 1, seriesId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            delay(50)
            seriesUseCase.getSeriesById.invoke(seriesId).collect { resource ->
                _seriesDetailState.value = when (resource) {
                    is Resource.Loading -> SeriesState.Loading
                    is Resource.Success -> SeriesState.Success(resource.data)
                    is Resource.Error -> SeriesState.Error(resource.message)
                }
            }
        }
    }
}