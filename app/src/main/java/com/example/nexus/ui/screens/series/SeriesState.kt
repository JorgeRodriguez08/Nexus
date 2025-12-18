package com.example.nexus.ui.screens.series

import com.example.nexus.domain.model.Serie

sealed class SeriesState {
    object Loading : SeriesState()
    data class Success(val results : List<Serie>) : SeriesState()
    data class Error(val message: String) : SeriesState()
}