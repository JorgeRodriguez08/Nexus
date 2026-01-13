package com.example.nexus.ui.screens.serieDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nexus.common.core.Resource
import com.example.nexus.domain.usecase.series.SeriesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SerieDetailsViewModel(
    private val seriesUseCase: SeriesUseCase
) : ViewModel() {

    private val _selectedSeasonNumber = MutableStateFlow<Int>(1)
    var selectedSeasonNumber: StateFlow<Int> = _selectedSeasonNumber.asStateFlow()

    private val _serieIntegratedState = MutableStateFlow<SerieIntegratedState>(SerieIntegratedState.Loading)
    val serieIntegratedState: StateFlow<SerieIntegratedState> = _serieIntegratedState.asStateFlow()
    private val _seasonDetailsState = MutableStateFlow<SeasonDetailsState>(SeasonDetailsState.Loading)
    val seasonDetailsState: StateFlow<SeasonDetailsState> = _seasonDetailsState.asStateFlow()

    private val _seasonsDetailsState = MutableStateFlow<Map<Int, SeasonDetailsState>>(emptyMap())

    fun changeSeason(seasonNumber: Int) {
        _selectedSeasonNumber.value = seasonNumber
        val seasonsDetailsState = _seasonsDetailsState.value
        val seasonDetailsState = seasonsDetailsState[seasonNumber]
        if (seasonDetailsState != null)
            _seasonDetailsState.value = seasonDetailsState
    }

    fun loadSerieIntegrated(serieId: Int) {
        viewModelScope.launch {
            seriesUseCase.getSerieIntegrated.invoke(serieId).collect { resource ->
                when (resource) {
                    is Resource.Loading -> SerieIntegratedState.Loading
                    is Resource.Success -> {
                        _serieIntegratedState.value = SerieIntegratedState.Success(resource.data)
                        val seasons = resource.data.serieDetails.seasons
                        seasons.forEach {
                            season -> loadSeasonsDetails(serieId, season.seasonNumber)
                        }
                    }
                    is Resource.Error -> SerieIntegratedState.Error(resource.message)
                }
            }
        }
    }

    private fun loadSeasonsDetails(serieId: Int, seasonNumber: Int) {
        viewModelScope.launch {
            seriesUseCase.getSeasonDetails.invoke(serieId, seasonNumber).collect { resource ->
                val updateSeasonsDetailsState = _seasonsDetailsState.value.toMutableMap()
                updateSeasonsDetailsState[seasonNumber] = when (resource) {
                    is Resource.Loading -> SeasonDetailsState.Loading
                    is Resource.Success -> SeasonDetailsState.Success(resource.data)
                    is Resource.Error -> SeasonDetailsState.Error(resource.message)
                }
                val firstSeasonDetailsState = updateSeasonsDetailsState[1]
                if (firstSeasonDetailsState != null && (seasonNumber == 1)) {
                    _seasonDetailsState.value = firstSeasonDetailsState
                }
                _seasonsDetailsState.value = updateSeasonsDetailsState
            }
        }
    }
}