package com.example.nexus.ui.screens.home

import com.example.nexus.ui.screens.movies.MoviesCategory
import com.example.nexus.ui.screens.series.SeriesCategory

object HomeCategories {
    val rows = listOf(
        HomeRow.SeriesRow(SeriesCategory.News),
        HomeRow.SeriesRow(SeriesCategory.Action),
        HomeRow.MoviesRow(MoviesCategory.Action),
        HomeRow.SeriesRow(SeriesCategory.Western),
        HomeRow.MoviesRow(MoviesCategory.Adventure),
        HomeRow.SeriesRow(SeriesCategory.ScienceFiction),
        HomeRow.MoviesRow(MoviesCategory.ScienceFiction),
        HomeRow.SeriesRow(SeriesCategory.Mystery),
        HomeRow.MoviesRow(MoviesCategory.Mystery),
        HomeRow.MoviesRow(MoviesCategory.Fantasy),
        HomeRow.MoviesRow(MoviesCategory.Horror),
        HomeRow.SeriesRow(SeriesCategory.Crime),
        HomeRow.MoviesRow(MoviesCategory.Crime),
        HomeRow.MoviesRow(MoviesCategory.Romance),
        HomeRow.SeriesRow(SeriesCategory.Drama),
        HomeRow.MoviesRow(MoviesCategory.Drama),
        HomeRow.SeriesRow(SeriesCategory.Comedy),
        HomeRow.MoviesRow(MoviesCategory.Comedy),
        HomeRow.SeriesRow(SeriesCategory.War),
        HomeRow.MoviesRow(MoviesCategory.War),
        HomeRow.SeriesRow(SeriesCategory.Documentary),
        HomeRow.MoviesRow(MoviesCategory.Documentary),
        HomeRow.SeriesRow(SeriesCategory.Reality),
        HomeRow.MoviesRow(MoviesCategory.TvMovie),
        HomeRow.SeriesRow(SeriesCategory.Talk),
        HomeRow.MoviesRow(MoviesCategory.Music),
        HomeRow.SeriesRow(SeriesCategory.Animation),
        HomeRow.MoviesRow(MoviesCategory.Animation),
        HomeRow.SeriesRow(SeriesCategory.Family),
        HomeRow.MoviesRow(MoviesCategory.Family),
        HomeRow.SeriesRow(SeriesCategory.Soap),
        HomeRow.MoviesRow(MoviesCategory.History),
        HomeRow.SeriesRow(SeriesCategory.Kids),
    )
}