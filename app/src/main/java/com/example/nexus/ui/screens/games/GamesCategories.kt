package com.example.nexus.ui.screens.games

import com.example.nexus.ui.screens.movies.MoviesCategory
import com.example.nexus.ui.screens.series.SeriesCategory

object GamesCategories {
    val rows = listOf(
        GamesRow.SeriesRow(SeriesCategory.Kids),
        GamesRow.SeriesRow(SeriesCategory.Family),
        GamesRow.MoviesRow(MoviesCategory.Family),
        GamesRow.SeriesRow(SeriesCategory.Kids),
        GamesRow.MoviesRow(MoviesCategory.Fantasy),
        GamesRow.SeriesRow(SeriesCategory.Animation),
        GamesRow.MoviesRow(MoviesCategory.Animation),
        GamesRow.SeriesRow(SeriesCategory.Soap),
        GamesRow.MoviesRow(MoviesCategory.Animation),
        GamesRow.SeriesRow(SeriesCategory.Kids),
        GamesRow.MoviesRow(MoviesCategory.Family),
        GamesRow.SeriesRow(SeriesCategory.Animation),
    )
}