package com.example.nexus.ui.navigation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class NavigationViewModel : ViewModel() {

    private val _currentRoute = MutableStateFlow(NexusScreen.Home.route)
    val currentRoute: StateFlow<String> = _currentRoute.asStateFlow()

    fun onRouteChanged(route: String) {
        _currentRoute.value = route
    }

    fun shouldShowFilter(): Boolean {
        val screensFilter = screensFilter
        return _currentRoute.value in screensFilter
    }

    fun canNavigateBack(): Boolean {
        return _currentRoute.value != NexusScreen.Home.route
    }

}