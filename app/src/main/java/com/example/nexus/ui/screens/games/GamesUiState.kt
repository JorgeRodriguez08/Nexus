package com.example.nexus.ui.screens.games

import com.example.nexus.ui.screens.movies.MoviesState
import com.example.nexus.ui.screens.series.SeriesState

data class GamesUiState(
    val moviesMap: Map<GameMovieCategory, MoviesState> = emptyMap(),
    val seriesMap: Map<GameSerieCategory, SeriesState> = emptyMap()
)