package com.example.nexus.ui.screens.games

import com.example.nexus.domain.model.Movie
import com.example.nexus.domain.model.Serie
import com.example.nexus.ui.screens.movies.MoviesCategory
import com.example.nexus.ui.screens.series.SeriesCategory

data class GamesUiState(
    val moviesMap: Map<MoviesCategory, GamesState<Movie>> = emptyMap(),
    val serieMap: Map<SeriesCategory, GamesState<Serie>> = emptyMap(),
    val rows: List<GamesRow> = emptyList()
)