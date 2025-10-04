package com.example.nexus.ui.screens.series

sealed class SeriesState<out Series> {

    object Loading : SeriesState<Nothing>()
    data class Success<Series>(val items: List<Series>) : SeriesState<Series>()
    data class Error(val message: String) : SeriesState<Nothing>()

}