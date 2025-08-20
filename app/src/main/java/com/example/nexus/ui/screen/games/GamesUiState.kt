package com.example.nexus.ui.screen.games

import android.app.GameState
import com.example.nexus.domain.model.Movie
import com.example.nexus.domain.model.Series
import com.example.nexus.ui.screen.movies.MoviesCategory
import com.example.nexus.ui.screen.series.SeriesCategory

data class GamesUiState(
    val moviesMap: Map<MoviesCategory, GamesState<Movie>> = emptyMap(),
    val seriesMap: Map<SeriesCategory, GamesState<Series>> = emptyMap(),
    val rows: List<GamesRow> = emptyList()
)