package com.example.nexus.ui.screens.serieDetails

import com.example.nexus.domain.model.SerieIntegrated

sealed class SerieIntegratedState {
    object Loading : SerieIntegratedState()
    data class Success(val serieIntegrated: SerieIntegrated) : SerieIntegratedState()
    data class Error(val message: String) : SerieIntegratedState()
}