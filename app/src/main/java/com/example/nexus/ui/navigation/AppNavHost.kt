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
import com.example.nexus.ui.components.bottomappbar.BottomBar
import com.example.nexus.ui.components.topappbar.TopBar
import com.example.nexus.ui.screens.categories.CategoriesScreen
import com.example.nexus.ui.screens.games.GamesScreen
import com.example.nexus.ui.screens.games.GamesViewModel
import com.example.nexus.ui.screens.home.HomeScreen
import com.example.nexus.ui.screens.home.HomeViewModel
import com.example.nexus.ui.screens.movieDetails.MovieDetailsScreen
import com.example.nexus.ui.screens.movieDetails.MovieDetailsViewModel
import com.example.nexus.ui.screens.movies.MoviesScreen
import com.example.nexus.ui.screens.movies.MoviesViewModel
import com.example.nexus.ui.screens.newsPopular.NewsAndPopularScreen
import com.example.nexus.ui.screens.newsPopular.NewsAndPopularViewModel
import com.example.nexus.ui.screens.search.SearchScreen
import com.example.nexus.ui.screens.search.SearchViewModel
import com.example.nexus.ui.screens.series.SeriesScreen
import com.example.nexus.ui.screens.series.SeriesViewModel
import com.example.nexus.ui.screens.serieDetails.SerieDetailsScreen
import com.example.nexus.ui.screens.serieDetails.SerieDetailsViewModel
import com.example.nexus.ui.theme.Dimens
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val navigationViewModel: NavigationViewModel = koinViewModel()
    val currentRoute = navigationViewModel.currentRoute.collectAsState().value

    val newsAndPopularViewModel: NewsAndPopularViewModel = koinViewModel()
    val selectedFilter = newsAndPopularViewModel.selectedFilter.collectAsState().value

    Scaffold(
        topBar = {
            if (Destinations.shouldShowTopBar(currentRoute)) {
                TopBar(
                    currentRoute = currentRoute,
                    selectedNewFilter = selectedFilter,
                    canNavigateBack = navigationViewModel.canNavigateBack(),
                    onBackClick = { navController.navigateUp() },
                    onSearchClick = { navController.navigate(Destinations.Search.route) },
                    onDownloadClick = { navController.navigate(Destinations.MyNexus.route) },
                    onFilterSelected = { filter ->
                        navController.navigate(filter)
                        navigationViewModel.onRouteChanged(filter)
                    },
                    onNewFilterSelected = { newFilter ->
                        newsAndPopularViewModel.setFilter(newFilter)
                    }
                )
            }
        },
        bottomBar = {
            if (Destinations.shouldShowBottomBar(currentRoute)) {
                BottomBar(
                    currentRoute = currentRoute,
                    onNavigate = { currentRoute ->
                        navController.navigate(currentRoute)
                        navigationViewModel.onRouteChanged(currentRoute)
                    }
                )
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Destinations.Home.route,
            modifier = modifier.padding(innerPadding)
        ) {
            composable(route = Destinations.Movies.route) {
                navigationViewModel.onRouteChanged(Destinations.Movies.route)
                val moviesViewModel: MoviesViewModel = koinViewModel()
                MoviesScreen(
                    moviesViewModel = moviesViewModel,
                    onMovieClick = { id -> navController.navigate(Destinations.MovieDetail.create(id)) }
                )
            }

            composable(route = Destinations.Series.route) {
                navigationViewModel.onRouteChanged(Destinations.Series.route)
                val seriesViewModel: SeriesViewModel = koinViewModel()
                SeriesScreen(
                    seriesViewModel = seriesViewModel,
                    onSerieClick = { id -> navController.navigate(Destinations.SerieDetail.create(id)) }
                )
            }

            composable(route = Destinations.Categories.route) {
                navigationViewModel.onRouteChanged(Destinations.Categories.route)
                CategoriesScreen(

                )
            }

            composable(route = Destinations.Search.route) {
                navigationViewModel.onRouteChanged(Destinations.Search.route)
                val searchViewModel: SearchViewModel = koinViewModel()
                SearchScreen(
                    searchViewModel = searchViewModel
                )
            }

            composable(route = Destinations.Home.route) {
                navigationViewModel.onRouteChanged(Destinations.Home.route)
                val homeViewModel: HomeViewModel = koinViewModel()
                HomeScreen(
                    homeViewModel = homeViewModel,
                    onMovieClick = { id -> navController.navigate(Destinations.MovieDetail.create(id)) },
                    onSerieClick = { id -> navController.navigate(Destinations.SerieDetail.create(id)) }
                )
            }

            composable(route = Destinations.Games.route) {
                navigationViewModel.onRouteChanged(Destinations.Games.route)
                val gamesViewModel: GamesViewModel = koinViewModel()
                GamesScreen(
                    gamesViewModel = gamesViewModel,
                    onMovieClick = { id -> navController.navigate(Destinations.MovieDetail.create(id)) },
                    onSerieClick = { id -> navController.navigate(Destinations.SerieDetail.create(id)) }
                )
            }

            composable(route = Destinations.NewsAndPopular.route) {
                navigationViewModel.onRouteChanged(Destinations.NewsAndPopular.route)
                NewsAndPopularScreen(
                    newsAndPopularViewModel = newsAndPopularViewModel,
                    selectedFilter = selectedFilter
                )
            }

            composable(route = Destinations.MyNexus.route) {
                navigationViewModel.onRouteChanged(Destinations.MyNexus.route)
            }

            composable(
                route = Destinations.MovieDetail.route,
                arguments = listOf(navArgument(Destinations.MovieDetail.ARGUMENT) { type = NavType.IntType })
            ) { backStackEntry ->
                val movieId = backStackEntry.arguments?.getInt(Destinations.MovieDetail.ARGUMENT) ?: return@composable
                navigationViewModel.onRouteChanged(Destinations.MovieDetail.create(movieId))
                val movieDetailsViewModel: MovieDetailsViewModel = koinViewModel()
                MovieDetailsScreen(
                    movieDetailsViewModel = movieDetailsViewModel,
                    movieId = movieId
                )
            }

            composable(
                route = Destinations.SerieDetail.route,
                arguments = listOf(navArgument(Destinations.SerieDetail.ARGUMENT) { type = NavType.IntType })
            ) { backStackEntry ->
                val serieId = backStackEntry.arguments?.getInt(Destinations.SerieDetail.ARGUMENT) ?: return@composable
                navigationViewModel.onRouteChanged(Destinations.MovieDetail.create(serieId))
                val serieDetailsViewModel: SerieDetailsViewModel = koinViewModel()
                SerieDetailsScreen(
                    serieDetailsViewModel = serieDetailsViewModel,
                    serieId = serieId
                )
            }
        }
    }
}