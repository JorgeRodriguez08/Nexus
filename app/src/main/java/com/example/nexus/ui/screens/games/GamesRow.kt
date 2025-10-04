package com.example.nexus.ui.screens.games

import com.example.nexus.ui.screens.movies.MoviesCategory
import com.example.nexus.ui.screens.series.SeriesCategory

sealed class GamesRow(val title: String) {
    class MoviesRow(val category: MoviesCategory) : GamesRow(category.title)
    class SeriesRow(val category: SeriesCategory) : GamesRow(category.title)
}
