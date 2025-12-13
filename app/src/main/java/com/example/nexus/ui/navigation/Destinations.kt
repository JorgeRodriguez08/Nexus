package com.example.nexus.ui.navigation

sealed class Destinations(
    val route: String,
    val showTopBar: Boolean = true,
    val showBottomBar: Boolean = true,
    val showFilterBar: Boolean = true,
    val showNewsFilterBar: Boolean = false,
    val showSearchBar: Boolean = false
) {
    object Series : Destinations("Serie")
    object Movies : Destinations("Películas")
    object Categories : Destinations("Categorías", showFilterBar = false)
    object Search : Destinations("Busqueda", showFilterBar = false, showBottomBar = false, showSearchBar = true)
    object Home : Destinations("Inicio")
    object Games : Destinations("Juegos", showFilterBar = false)
    object NewsAndPopular : Destinations("Nuevo y popular", showFilterBar = false, showNewsFilterBar = true)
    object MyNexus : Destinations("My Nexus", showFilterBar = false)

    data object MovieDetail : Destinations("detail/{movieId}", showBottomBar = false, showFilterBar = false) {
        fun create(id: Int) = "detail/$id"
        const val ARGUMENT = "movieId"
    }

    data object MovieVideo : Destinations("video/{videoUrl}", showTopBar = false, showBottomBar = false, showFilterBar = false) {
        fun create(videoUrl: String) = "video/$videoUrl"
        const val ARGUMENT = "videoUrl"
    }

    data object SeriesDetail: Destinations("detail/{seriesId}", showFilterBar = false) {
        fun create(id: Int) = "detail/$id"
        const val ARGUMENT = "seriesId"
    }

    companion object {

        val screensFilter = listOf(Series.route, Movies.route, Categories.route)

        fun findDestination(route: String): Destinations? {
            return screens().firstOrNull { base ->
                val baseRoute = base.route.substringBefore("/{")
                route.startsWith(baseRoute)
            }
        }

        fun shouldShowTopBar(route: String): Boolean {
            return findDestination(route)?.showTopBar ?: true
        }

        fun shouldShowBottomBar(route: String): Boolean {
            return findDestination(route)?.showBottomBar ?: true
        }

        fun shouldShowFilterBar(route: String): Boolean {
            return findDestination(route)?.showFilterBar ?: true
        }

        fun shouldShowNewsFilterBar(route: String): Boolean {
            return findDestination(route)?.showNewsFilterBar ?: false
        }

        fun shouldShowSearchBar(route: String): Boolean {
            return findDestination(route)?.showSearchBar ?: false
        }

        fun screens() = listOf(
            Series, Movies, Categories, Search, Home, Games, NewsAndPopular, MyNexus, MovieDetail, MovieVideo, SeriesDetail
        )
    }
}
