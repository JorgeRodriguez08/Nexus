package com.example.nexus.ui.screens.serieDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nexus.common.core.Resource
import com.example.nexus.domain.usecase.series.SeriesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SerieDetailsViewModel(
    private val seriesUseCase: SeriesUseCase
) : ViewModel() {

    private val _serieDetailState = MutableStateFlow<SerieDetailState>(SerieDetailState.Loading)
    val serieDetailState: StateFlow<SerieDetailState> = _serieDetailState.asStateFlow()

    fun loadSerieDetails(seriesId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            seriesUseCase.getSerieDetails.invoke(seriesId).collect { resource ->
                _serieDetailState.value = when (resource) {
                    is Resource.Loading -> SerieDetailState.Loading
                    is Resource.Success -> SerieDetailState.Success(resource.data)
                    is Resource.Error -> SerieDetailState.Error(resource.message)
                }
            }
        }
    }
}