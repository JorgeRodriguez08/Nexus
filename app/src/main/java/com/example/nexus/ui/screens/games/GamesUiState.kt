package com.example.nexus.ui.screens.games

import com.example.nexus.ui.screens.movies.MovieCategory
import com.example.nexus.ui.screens.movies.MoviesState
import com.example.nexus.ui.screens.series.SerieCategory
import com.example.nexus.ui.screens.series.SeriesState

data class GamesUiState(
    val moviesMap: Map<MovieCategory, MoviesState> = emptyMap(),
    val seriesMap: Map<SerieCategory, SeriesState> = emptyMap()
)