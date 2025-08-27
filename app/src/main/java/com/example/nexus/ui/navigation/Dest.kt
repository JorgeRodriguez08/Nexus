package com.example.nexus.ui.navigation

sealed class Dest(val route: String) {
    object Series : Dest("Series")
    object Movies : Dest("Películas")
    object Categories : Dest("Categorías")
    object Search : Dest("Busqueda")

    object Home : Dest("Inicio")
    object Games : Dest("Juegos")
    object NewsAndPopular : Dest("Nuevo y popular")
    object MyNexus : Dest("My Nexus")

    data object MovieDetail : Dest("detail/{movieId}") {
        fun create(id: Int) = "detail/$id"
        const val ARGUMENT = "movieId"
    }

    data object SeriesDetail: Dest("detail/{seriesId}") {
        fun create(id: Int) = "detail/$id"
        const val ARGUMENT = "seriesId"
    }
}

val screens = listOf(
    Dest.Series,
    Dest.Movies,
    Dest.Categories,
    Dest.Home,
    Dest.Games,
    Dest.NewsAndPopular,
    Dest.MyNexus
)

val screensFilter = listOf(
    Dest.Series.route,
    Dest.Movies.route,
    Dest.Categories.route
)
