package com.example.nexus.ui.screen.series

import com.example.nexus.domain.model.Series

data class SeriesUiState(
    val seriesUiState: Map<SeriesCategory, SeriesState<Series>> = emptyMap()
)
