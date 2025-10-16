package com.example.nexus.ui.navigation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class NavigationViewModel : ViewModel() {

    private val _currentRoute = MutableStateFlow(Destinations.Home.route)
    val currentRoute: StateFlow<String> = _currentRoute.asStateFlow()

    fun onRouteChanged(route: String) {
        _currentRoute.value = route
    }

    fun canNavigateBack(): Boolean {
        return _currentRoute.value != Destinations.Home.route
    }

}