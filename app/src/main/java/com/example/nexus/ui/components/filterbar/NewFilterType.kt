package com.example.nexus.ui.components.filterbar

import com.example.nexus.ui.theme.Strings

sealed class NewFilterType(val label: String) {
    object Upcoming : NewFilterType(Strings.NewsFilters.upcoming)
    object Popular : NewFilterType(Strings.NewsFilters.popular)
    object MobileGames : NewFilterType(Strings.NewsFilters.mobileGames)
    object Top10Movies : NewFilterType(Strings.NewsFilters.top10Movies)
    object Top10Series : NewFilterType(Strings.NewsFilters.top10Series)

    companion object {
        fun values(): List<NewFilterType> = listOf(
            Upcoming,
            Popular,
            MobileGames,
            Top10Movies,
            Top10Series
        )
    }
}