package com.example.nexus.ui.screens.serieDetails

import com.example.nexus.domain.model.SeasonDetails

sealed class SeasonDetailsState {
    object Loading : SeasonDetailsState()
    data class Success(val seasonDetails: SeasonDetails) : SeasonDetailsState()
    data class Error(val message: String) : SeasonDetailsState()
}