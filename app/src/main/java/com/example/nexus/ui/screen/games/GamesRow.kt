package com.example.nexus.ui.screen.games

import com.example.nexus.ui.screen.movies.MoviesCategory
import com.example.nexus.ui.screen.series.SeriesCategory

sealed class GamesRow(val title: String) {
    class MoviesRow(val category: MoviesCategory) : GamesRow(category.title)
    class SeriesRow(val category: SeriesCategory) : GamesRow(category.title)
}
