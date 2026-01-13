package com.example.nexus.ui.screens.serieDetails

import com.example.nexus.domain.model.SerieDetails

sealed class SerieDetailsState {
    object Loading : SerieDetailsState()
    data class Success(val serieDetails: SerieDetails) : SerieDetailsState()
    data class Error(val message: String) : SerieDetailsState()
}