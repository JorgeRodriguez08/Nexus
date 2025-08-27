package com.example.nexus.ui.screen.seriesDetail

sealed class SeriesState<out Series> {
    object Loading : SeriesState<Nothing>()
    data class Success<Series>(val item: Series) : SeriesState<Series>()
    data class Error(val message: String) : SeriesState<Nothing>()
}