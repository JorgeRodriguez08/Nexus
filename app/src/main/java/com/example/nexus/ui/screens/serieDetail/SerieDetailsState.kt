package com.example.nexus.ui.screens.serieDetail

sealed class SerieDetailsState {
    object Loading : SerieDetailsState()
    data class Success(val serieDetails: SerieDetails) : SerieDetailsState()
    data class Error(val message: String) : SerieDetailsState()
}