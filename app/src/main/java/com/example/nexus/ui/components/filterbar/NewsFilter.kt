package com.example.nexus.ui.components.filterbar

import com.example.nexus.ui.theme.Strings

sealed class NewsFilter(val label: String) {
    object Upcoming : NewsFilter(Strings.NewsFilters.upcoming)
    object Cool : NewsFilter(Strings.NewsFilters.cool)
    object MobileGames : NewsFilter(Strings.NewsFilters.mobileGames)
    object Top10Movies : NewsFilter(Strings.NewsFilters.top10Movies)
    object Top10Series : NewsFilter(Strings.NewsFilters.top10Series)

    companion object {
        fun values(): List<NewsFilter> = listOf(
            Upcoming,
            Cool,
            MobileGames,
            Top10Movies,
            Top10Series
        )
    }
}