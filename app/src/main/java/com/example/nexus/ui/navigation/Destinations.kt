package com.example.nexus.ui.navigation

sealed class Destinations(
    val route: String,
    val showTopBar: Boolean = true,
    val showBottomBar: Boolean = true,
    val showFilterBar: Boolean = true,
    val showNewsFilterBar: Boolean = false,
    val showSearchBar: Boolean = false
) {
    object Movies : Destinations(NavRoutes.MOVIES)
    object Series : Destinations(NavRoutes.SERIES)
    object Home : Destinations(NavRoutes.HOME)
    object Games : Destinations(NavRoutes.GAMES, showFilterBar = false)
    object NewsAndPopular : Destinations(NavRoutes.NEWS_AND_POPULAR, showFilterBar = false, showNewsFilterBar = true)
    object MyNexus : Destinations(NavRoutes.MY_NEXUS, showFilterBar = false)
    object Categories : Destinations(NavRoutes.CATEGORIES, showFilterBar = false)
    object Search : Destinations(NavRoutes.SEARCH, showBottomBar = false, showFilterBar = false, showSearchBar = true)
    data object MovieDetail : Destinations("detail/{movieId}", showBottomBar = false, showFilterBar = false) {
        fun create(id: Int) = "detail/$id"
        const val ARGUMENT = NavRoutes.MOVIE_ID
    }
    data object SerieDetail: Destinations("detail/{serieId}", showFilterBar = false) {
        fun create(id: Int) = "detail/$id"
        const val ARGUMENT = NavRoutes.SERIE_ID
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
            Movies,
            Series,
            Home,
            Games,
            NewsAndPopular,
            MyNexus,
            Categories,
            Search,
            MovieDetail,
            SerieDetail
        )
    }
}