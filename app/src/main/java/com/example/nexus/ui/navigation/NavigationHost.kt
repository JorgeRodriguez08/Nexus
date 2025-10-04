package com.example.nexus.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.nexus.ui.components.bottomappbar.NexusBottomAppBar
import com.example.nexus.ui.components.topappbar.NexusTopAppBar
import com.example.nexus.ui.screens.categories.CategoriesScreen
import com.example.nexus.ui.screens.movieDetail.MovieDetailScreen
import com.example.nexus.ui.screens.movieDetail.MovieDetailViewModel
import com.example.nexus.ui.screens.games.GamesScreen
import com.example.nexus.ui.screens.games.GamesViewModel
import com.example.nexus.ui.screens.home.HomeScreen
import com.example.nexus.ui.screens.home.HomeViewModel
import com.example.nexus.ui.screens.movies.MoviesScreen
import com.example.nexus.ui.screens.series.SeriesScreen
import com.example.nexus.ui.screens.series.SeriesViewModel
import com.example.nexus.ui.screens.movies.MoviesViewModel
import com.example.nexus.ui.screens.seriesDetail.SeriesDetailScreen
import com.example.nexus.ui.screens.seriesDetail.SeriesDetailViewModel
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
                onSearchClick = { navController.navigate(Destinations.Search.route) },
                onBackClick = { navController.navigate(Destinations.Home.route) },
                onDownloadClick = { navController.navigate(Destinations.MyNexus.route) },
                onFilterSelected = { selectedRoute ->
                    navigationViewModel.onRouteChanged(selectedRoute)
                    navController.navigate(selectedRoute)
                }
            )
        },
        bottomBar = {
            NexusBottomAppBar(
                currentRoute = currentRoute,
                onNavigate = { route ->
                    navController.navigate(route)
                    navigationViewModel.onRouteChanged(route)
                }

            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = currentRoute,
            modifier = modifier.padding(innerPadding)
        ) {
            composable(route = Destinations.Series.route) {
                navigationViewModel.onRouteChanged(Destinations.Series.route)
                val seriesViewModel: SeriesViewModel = koinViewModel()
                SeriesScreen(
                    seriesViewModel,
                    onSeriesClick = {id -> navController.navigate(Destinations.SeriesDetail.create(id)) }
                )
            }

            composable(route = Destinations.Movies.route) {
                navigationViewModel.onRouteChanged(Destinations.Movies.route)
                val moviesViewModel: MoviesViewModel = koinViewModel()
                MoviesScreen(
                    moviesViewModel,
                    onMovieClick = {id -> navController.navigate(Destinations.MovieDetail.create(id))
                    }
                )
            }

            composable(
                route = Destinations.SeriesDetail.route,
                arguments = listOf(navArgument(Destinations.SeriesDetail.ARGUMENT) { type = NavType.IntType })
            ) { backStackEntry ->
                val seriesId = backStackEntry.arguments?.getInt(Destinations.SeriesDetail.ARGUMENT) ?: return@composable
                val seriesDetailViewModel: SeriesDetailViewModel = koinViewModel()
                SeriesDetailScreen(
                    seriesDetailViewModel,
                    seriesId
                )
            }

            composable(
                route = Destinations.MovieDetail.route,
                arguments = listOf(navArgument(Destinations.MovieDetail.ARGUMENT) { type = NavType.IntType })
            ) { backStackEntry ->
                val movieId = backStackEntry.arguments?.getInt(Destinations.MovieDetail.ARGUMENT) ?: return@composable
                val movieDetailViewModel: MovieDetailViewModel = koinViewModel()
                MovieDetailScreen(
                    movieDetailViewModel,
                    movieId
                )
            }

            composable(route = Destinations.Categories.route) {
                navigationViewModel.onRouteChanged(Destinations.Categories.route)
                CategoriesScreen()
            }

            composable(route = Destinations.Search.route) {
                navigationViewModel.onRouteChanged(Destinations.Search.route)

            }

            composable(route = Destinations.Home.route) {
                navigationViewModel.onRouteChanged(Destinations.Home.route)
                val homeViewModel: HomeViewModel = koinViewModel()
                HomeScreen(
                    homeViewModel,
                    onMovieClick = { id -> navController.navigate(Destinations.MovieDetail.create(id)) },
                    onSeriesClick = { id -> navController.navigate(Destinations.SeriesDetail.create(id)) }
                )
            }

            composable(route = Destinations.Games.route) {
                navigationViewModel.onRouteChanged(Destinations.Games.route)
                val gamesViewModel: GamesViewModel = koinViewModel()
                GamesScreen(
                    gamesViewModel,
                    onMovieClick = { id -> navController.navigate(Destinations.MovieDetail.create(id)) },
                    onSeriesClick = { id -> navController.navigate(Destinations.SeriesDetail.create(id)) }
                )
            }

            composable(route = Destinations.NewsAndPopular.route) {
                navigationViewModel.onRouteChanged(Destinations.NewsAndPopular.route)

            }

            composable(route = Destinations.MyNexus.route) {
                navigationViewModel.onRouteChanged(Destinations.MyNexus.route)

            }
        }
    }
}
