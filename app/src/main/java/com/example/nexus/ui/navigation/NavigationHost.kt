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
import com.example.nexus.ui.screen.categories.CategoriesScreen
import com.example.nexus.ui.screen.movieDetail.MovieDetailScreen
import com.example.nexus.ui.screen.movieDetail.MovieDetailViewModel
import com.example.nexus.ui.screen.games.GamesScreen
import com.example.nexus.ui.screen.games.GamesViewModel
import com.example.nexus.ui.screen.home.HomeScreen
import com.example.nexus.ui.screen.home.HomeViewModel
import com.example.nexus.ui.screen.movies.MoviesScreen
import com.example.nexus.ui.screen.series.SeriesScreen
import com.example.nexus.ui.screen.series.SeriesViewModel
import com.example.nexus.ui.screen.movies.MoviesViewModel
import com.example.nexus.ui.screen.seriesDetail.SeriesDetailScreen
import com.example.nexus.ui.screen.seriesDetail.SeriesDetailViewModel
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
                onSearchClick = { navController.navigate(Dest.Search.route) },
                onBackClick = { navController.navigate(Dest.Home.route) },
                onDownloadClick = { navController.navigate(Dest.MyNexus.route) },
                onFilterSelected = { selectedRoute ->
                    navigationViewModel.onRouteChanged(selectedRoute)
                    navController.navigate(selectedRoute)
                }
            )
        },
        bottomBar = {
            NexusBottomAppBar(
                onHome = {
                    navigationViewModel.onRouteChanged(Dest.Home.route)
                    navController.navigate(Dest.Home.route)},
                onGames = {
                    navigationViewModel.onRouteChanged(Dest.Games.route)
                    navController.navigate(Dest.Games.route) },
                onNewsAndPopular = {
                    navigationViewModel.onRouteChanged(Dest.NewsAndPopular.route)
                    navController.navigate(Dest.NewsAndPopular.route) },
                onMyNexus = {
                    navigationViewModel.onRouteChanged(Dest.MyNexus.route)
                    navController.navigate(Dest.MyNexus.route) },
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Dest.Home.route,
            modifier = modifier.padding(innerPadding)
        ) {
            composable(route = Dest.Series.route) {
                navigationViewModel.onRouteChanged(Dest.Series.route)
                val seriesViewModel: SeriesViewModel = koinViewModel()
                SeriesScreen(
                    seriesViewModel,
                    onSeriesClick = {id -> navController.navigate(Dest.SeriesDetail.create(id)) }
                )
            }

            composable(route = Dest.Movies.route) {
                navigationViewModel.onRouteChanged(Dest.Movies.route)
                val moviesViewModel: MoviesViewModel = koinViewModel()
                MoviesScreen(
                    moviesViewModel,
                    onMovieClick = {id -> navController.navigate(Dest.MovieDetail.create(id))
                    }
                )
            }

            composable(
                route = Dest.SeriesDetail.route,
                arguments = listOf(navArgument(Dest.SeriesDetail.ARGUMENT) { type = NavType.IntType })
            ) { backStackEntry ->
                val seriesId = backStackEntry.arguments?.getInt(Dest.SeriesDetail.ARGUMENT) ?: return@composable
                val seriesDetailViewModel: SeriesDetailViewModel = koinViewModel()
                SeriesDetailScreen(
                    seriesDetailViewModel,
                    seriesId
                )
            }

            composable(
                route = Dest.MovieDetail.route,
                arguments = listOf(navArgument(Dest.MovieDetail.ARGUMENT) { type = NavType.IntType })
            ) { backStackEntry ->
                val movieId = backStackEntry.arguments?.getInt(Dest.MovieDetail.ARGUMENT) ?: return@composable
                val movieDetailViewModel: MovieDetailViewModel = koinViewModel()
                MovieDetailScreen(
                    movieDetailViewModel,
                    movieId
                )
            }

            composable(route = Dest.Categories.route) {
                navigationViewModel.onRouteChanged(Dest.Categories.route)
                CategoriesScreen()
            }

            composable(route = Dest.Search.route) {

            }

            composable(route = Dest.Home.route) {
                navigationViewModel.onRouteChanged(Dest.Home.route)
                val homeViewModel: HomeViewModel = koinViewModel()
                HomeScreen(
                    homeViewModel,
                    onMovieClick = { id -> navController.navigate(Dest.MovieDetail.create(id)) },
                    onSeriesClick = { id -> navController.navigate(Dest.SeriesDetail.create(id)) }
                )
            }

            composable(route = Dest.Games.route) {
                val gamesViewModel: GamesViewModel = koinViewModel()
                GamesScreen(
                    gamesViewModel,
                    onMovieClick = { id -> navController.navigate(Dest.MovieDetail.create(id)) },
                    onSeriesClick = { id -> navController.navigate(Dest.SeriesDetail.create(id)) }
                )
            }

            composable(route = Dest.NewsAndPopular.route) {

            }

            composable(route = Dest.MyNexus.route) {

            }
        }
    }
}


