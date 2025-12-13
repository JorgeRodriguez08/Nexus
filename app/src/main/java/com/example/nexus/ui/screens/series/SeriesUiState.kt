package com.example.nexus.ui.screens.series

import com.example.nexus.domain.model.Serie

data class SeriesUiState(
    val serieUiState: Map<SeriesCategory, SeriesState<Serie>> = emptyMap()
)
