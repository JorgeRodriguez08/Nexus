package com.example.nexus.ui.screens.home

import com.example.nexus.ui.screens.movies.MoviesCategory
import com.example.nexus.ui.screens.series.SeriesCategory

sealed class HomeRow(val title: String) {
    class MoviesRow(val category: MoviesCategory) : HomeRow(category.title)
    class SeriesRow(val category: SeriesCategory) : HomeRow(category.title)
}