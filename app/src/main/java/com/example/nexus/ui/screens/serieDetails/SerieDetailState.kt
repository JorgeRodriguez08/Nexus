package com.example.nexus.ui.screens.serieDetails

import com.example.nexus.domain.model.SerieDetails

sealed class SerieDetailState {
    object Loading : SerieDetailState()
    data class Success(val serieDetails: SerieDetails) : SerieDetailState()
    data class Error(val message: String) : SerieDetailState()
}