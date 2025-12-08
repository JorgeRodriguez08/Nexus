package com.example.nexus.ui.screens.games

import com.example.nexus.domain.models.Movie
import com.example.nexus.domain.models.Serie
import com.example.nexus.ui.screens.movies.MovieCategory
import com.example.nexus.ui.screens.series.SerieCategory

data class GamesUiState(
    val moviesMap: Map<MovieCategory, GamesState<Movie>> = emptyMap(),
    val seriesMap: Map<SerieCategory, GamesState<Serie>> = emptyMap(),
    val rows: List<GamesRow> = emptyList()
)