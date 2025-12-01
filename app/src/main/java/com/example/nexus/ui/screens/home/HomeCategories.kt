package com.example.nexus.ui.screens.home

import com.example.nexus.ui.screens.movies.MoviesCategory
import com.example.nexus.ui.screens.series.SeriesCategory

object HomeCategories {
    val rows = listOf(

        HomeRow.MoviesRow(MoviesCategory.War),
        HomeRow.SeriesRow(SeriesCategory.Trending),
        HomeRow.SeriesRow(SeriesCategory.News),
        HomeRow.SeriesRow(SeriesCategory.Crime),
        HomeRow.SeriesRow(SeriesCategory.AiringToday),
        HomeRow.SeriesRow(SeriesCategory.OnTheAir),
        HomeRow.MoviesRow(MoviesCategory.Mystery),
        HomeRow.SeriesRow(SeriesCategory.Romantic),
        HomeRow.SeriesRow(SeriesCategory.RomanticAsiatic),
        HomeRow.MoviesRow(MoviesCategory.Popular),
        HomeRow.MoviesRow(MoviesCategory.ActionAndThriller),
        HomeRow.SeriesRow(SeriesCategory.ActionAdventure),
        HomeRow.MoviesRow(MoviesCategory.TaqAction),
        HomeRow.SeriesRow(SeriesCategory.Crime),
        HomeRow.MoviesRow(MoviesCategory.Adventure),
        HomeRow.MoviesRow(MoviesCategory.Comedy),
        HomeRow.SeriesRow(SeriesCategory.RomanticKorea),
        HomeRow.MoviesRow(MoviesCategory.Horror),
        HomeRow.MoviesRow(MoviesCategory.NowPlaying),
        HomeRow.MoviesRow(MoviesCategory.Crime),
        HomeRow.MoviesRow(MoviesCategory.Thriller),
        HomeRow.SeriesRow(SeriesCategory.War),
        HomeRow.MoviesRow(MoviesCategory.UpComing),
        HomeRow.SeriesRow(SeriesCategory.Family),
        HomeRow.MoviesRow(MoviesCategory.ScienceFiction),
        HomeRow.MoviesRow(MoviesCategory.Fantasy),
        HomeRow.SeriesRow(SeriesCategory.Comedy),
        HomeRow.SeriesRow(SeriesCategory.Telenovela),
        HomeRow.MoviesRow(MoviesCategory.Trending),
        HomeRow.MoviesRow(MoviesCategory.Drama),
        HomeRow.SeriesRow(SeriesCategory.Mystery),
    )
}