package com.example.nexus.ui.screens.games

import com.example.nexus.ui.screens.movies.MovieCategory
import com.example.nexus.ui.screens.series.SerieCategory

sealed class GamesRow(val title: String) {
    class MoviesRow(val category: MovieCategory) : GamesRow(category.title)
    class SeriesRow(val category: SerieCategory) : GamesRow(category.title)
}
