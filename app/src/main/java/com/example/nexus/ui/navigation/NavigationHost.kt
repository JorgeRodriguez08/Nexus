package com.example.nexus.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.nexus.ui.components.bottomappbar.NexusBottomAppBar
import com.example.nexus.ui.components.topappbar.NexusTopAppBar
import com.example.nexus.ui.screen.categories.CategoriesScreen
import com.example.nexus.ui.screen.games.GamesScreen
import com.example.nexus.ui.screen.games.GamesViewModel
import com.example.nexus.ui.screen.home.HomeScreen
import com.example.nexus.ui.screen.home.HomeViewModel
import com.example.nexus.ui.screen.movies.MoviesScreen
import com.example.nexus.ui.screen.series.SeriesScreen
import com.example.nexus.ui.screen.series.SeriesViewModel
import com.example.nexus.ui.screen.movies.MoviesViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val navigationViewModel: NavigationViewModel = koinViewModel()
    val currentRoute = navigationViewModel.currentRoute.collectAsState().value
    Scaffold(
        topBar = {
            NexusTopAppBar(
                currentRoute = currentRoute,
                canNavigateBack = navigationViewModel.canNavigateBack(),
                onSearchClick = { navController.navigate(NexusScreen.Search.route) },
                onBackClick = { navController.popBackStack() },
                onDownloadClick = { navController.navigate(NexusScreen.MyNexus.route) },
                onFilterSelected = { selectedRoute ->
                    navigationViewModel.onRouteChanged(selectedRoute)
                    navController.navigate(selectedRoute)
                }
            )
        },
        bottomBar = {
            NexusBottomAppBar(
                onHome = {
                    navigationViewModel.onRouteChanged(NexusScreen.Home.route)
                    navController.navigate(NexusScreen.Home.route)},
                onGames = {
                    navigationViewModel.onRouteChanged(NexusScreen.Games.route)
                    navController.navigate(NexusScreen.Games.route) },
                onNewsAndPopular = {
                    navigationViewModel.onRouteChanged(NexusScreen.NewsAndPopular.route)
                    navController.navigate(NexusScreen.NewsAndPopular.route) },
                onMyNexus = {
                    navigationViewModel.onRouteChanged(NexusScreen.MyNexus.route)
                    navController.navigate(NexusScreen.MyNexus.route) },
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = NexusScreen.Home.route,
            modifier = modifier.padding(innerPadding)
        ) {
            composable(route = NexusScreen.Series.route) {
                navigationViewModel.onRouteChanged(NexusScreen.Series.route)
                val seriesViewModel: SeriesViewModel = koinViewModel()
                SeriesScreen(seriesViewModel)
            }

            composable(route = NexusScreen.Movies.route) {
                navigationViewModel.onRouteChanged(NexusScreen.Movies.route)
                val moviesViewModel: MoviesViewModel = koinViewModel()
                MoviesScreen(moviesViewModel)
            }

            composable(route = NexusScreen.Categories.route) {
                CategoriesScreen()
            }

            composable(route = NexusScreen.Search.route) {

            }

            composable(route = NexusScreen.Home.route) {
                val homeViewModel: HomeViewModel = koinViewModel()
                HomeScreen(homeViewModel)
            }

            composable(route = NexusScreen.Games.route) {
                val gamesViewModel: GamesViewModel = koinViewModel()
                GamesScreen(gamesViewModel)
            }

            composable(route = NexusScreen.NewsAndPopular.route) {

            }

            composable(route = NexusScreen.MyNexus.route) {

            }
        }
    }
}


