package com.example.nexus.ui.screens.games

import com.example.nexus.ui.screens.movies.MovieCategory
import com.example.nexus.ui.screens.series.SerieCategory

object GamesCategories {
    val rows = listOf(
        GamesRow.SeriesRow(SerieCategory.Kids),
        GamesRow.SeriesRow(SerieCategory.Family),
        GamesRow.MoviesRow(MovieCategory.Family),
        GamesRow.SeriesRow(SerieCategory.Kids),
        GamesRow.MoviesRow(MovieCategory.Fantasy),
        GamesRow.SeriesRow(SerieCategory.Animation),
        GamesRow.MoviesRow(MovieCategory.Animation),
        GamesRow.SeriesRow(SerieCategory.RomanticKorea),
        GamesRow.MoviesRow(MovieCategory.Animation),
        GamesRow.SeriesRow(SerieCategory.Kids),
        GamesRow.MoviesRow(MovieCategory.Family),
        GamesRow.SeriesRow(SerieCategory.Animation),
    )
}