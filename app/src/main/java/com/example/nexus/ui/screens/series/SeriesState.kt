package com.example.nexus.ui.screens.series

import com.example.nexus.domain.models.Serie

sealed class SeriesState {
    object Loading : SeriesState()
    data class Success(val results : List<Serie>) : SeriesState()
    data class Error(val message: String) : SeriesState()
}