package com.example.nexus.ui.screen.home

import com.example.nexus.domain.model.Movie
import com.example.nexus.domain.model.Series
import com.example.nexus.ui.screen.movies.MoviesCategory
import com.example.nexus.ui.screen.series.SeriesCategory

data class HomeUiState(
    val moviesMap: Map<MoviesCategory, HomeState<Movie>> = emptyMap(),
    val seriesMap: Map<SeriesCategory, HomeState<Series>> = emptyMap(),
    val rows: List<HomeRow> = emptyList()
)