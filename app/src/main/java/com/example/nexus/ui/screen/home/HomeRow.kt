package com.example.nexus.ui.screen.home

import com.example.nexus.ui.screen.movies.MoviesCategory
import com.example.nexus.ui.screen.series.SeriesCategory

sealed class HomeRow(val title: String) {
    class MoviesRow(val category: MoviesCategory) : HomeRow(category.title)
    class SeriesRow(val category: SeriesCategory) : HomeRow(category.title)
}