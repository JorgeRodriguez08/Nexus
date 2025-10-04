package com.example.nexus.ui.navigation

sealed class Destinations(val route: String) {
    object Series : Destinations("Series")
    object Movies : Destinations("Películas")
    object Categories : Destinations("Categorías")
    object Search : Destinations("Busqueda")

    object Home : Destinations("Inicio")
    object Games : Destinations("Juegos")
    object NewsAndPopular : Destinations("Nuevo y popular")
    object MyNexus : Destinations("My Nexus")

    data object MovieDetail : Destinations("detail/{movieId}") {
        fun create(id: Int) = "detail/$id"
        const val ARGUMENT = "movieId"
    }

    data object SeriesDetail: Destinations("detail/{seriesId}") {
        fun create(id: Int) = "detail/$id"
        const val ARGUMENT = "seriesId"
    }
}

val screensBottom = listOf(
    Destinations.Home.route,
    Destinations.Games.route,
    Destinations.NewsAndPopular.route,
    Destinations.MyNexus.route,
    Destinations.MovieDetail.route
)

val screensFilter = listOf(
    Destinations.Series.route,
    Destinations.Movies.route,
    Destinations.Categories.route,
)
