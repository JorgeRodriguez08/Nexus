package com.example.nexus.ui.navigation

sealed class NexusScreen(val route: String) {
    object Series : NexusScreen("Series")
    object Movies : NexusScreen("Películas")
    object Categories : NexusScreen("Categorías")
    object Search : NexusScreen("Busqueda")

    object Home : NexusScreen("Inicio")
    object Games : NexusScreen("Juegos")
    object NewsAndPopular : NexusScreen("Nuevo y popular")
    object MyNexus : NexusScreen("My Nexus")
}

val screens = listOf(
    NexusScreen.Series,
    NexusScreen.Movies,
    NexusScreen.Categories,
    NexusScreen.Home,
    NexusScreen.Games,
    NexusScreen.NewsAndPopular,
    NexusScreen.MyNexus
)

val screensFilter = listOf(
    NexusScreen.Series.route,
    NexusScreen.Movies.route,
    NexusScreen.Categories.route
)
