package com.example.nexus.ui.screens.newsPopular

sealed class FilterType(val label: String) {
    object Upcoming : FilterType("\uD83C\uDF7F Proximamente")
    object Popular : FilterType("\uD83D\uDD25 Lo más cool")
    object MobileGames : FilterType("\uD83C\uDFAE Juegos móviles")
    object Top10Series : FilterType("Las 10 series más populares")
    object Top10Movies : FilterType("Las 10 películas más populares")

    companion object {
        fun values(): List<FilterType> = listOf(
            Upcoming,
            Popular,
            MobileGames,
            Top10Series,
            Top10Movies
        )
    }
}

