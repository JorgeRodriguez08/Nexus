package com.example.nexus.ui.screens.home

import com.example.nexus.ui.screens.movies.MovieCategory
import com.example.nexus.ui.screens.movies.MoviesState
import com.example.nexus.ui.screens.series.SerieCategory
import com.example.nexus.ui.screens.series.SeriesState

data class HomeUiState(
    val moviesMap: Map<MovieCategory, MoviesState> = emptyMap(),
    val seriesMap: Map<SerieCategory, SeriesState> = emptyMap()
)