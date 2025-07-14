package com.example.nexus.ui.navigation

sealed class NexusScreen(val route: String) {
    object Home : NexusScreen("home")
    object News : NexusScreen("news")
    object Popular : NexusScreen("popular")
    object MyNexus : NexusScreen("my_nexus")
    object Search : NexusScreen("search")
}
