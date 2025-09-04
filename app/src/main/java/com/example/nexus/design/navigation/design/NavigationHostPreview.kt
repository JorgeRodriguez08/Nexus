package com.example.nexus.design.navigation.design

import android.content.res.Configuration
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.nexus.ui.navigation.Dest
import com.example.nexus.ui.components.bottomappbar.NexusBottomAppBar
import com.example.nexus.ui.components.topappbar.NexusTopAppBar
import com.example.nexus.ui.theme.NexusTheme

@OptIn(ExperimentalMaterial3Api::class)
@Preview(
    showBackground = true,
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    device = Devices.PIXEL_7
)
@Composable
fun NavigationHostPreview(
    modifier: Modifier = Modifier
) {
    NexusTheme {
        val navController = rememberNavController()
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route ?: Dest.Home.route
        val canNavigateBack = navController.previousBackStackEntry != null

        Scaffold(
            topBar = {
                NexusTopAppBar(
                    currentRoute = currentRoute,
                    canNavigateBack = canNavigateBack,
                    onSearchClick = { navController.navigate(Dest.Search.route) },
                    onBackClick = { navController.navigate(Dest.Home.route) },
                    onDownloadClick = { navController.navigate(Dest.MyNexus.route) },
                    onFilterSelected = { selectedRoute ->
                        navController.navigate(selectedRoute)
                    }
                )
            },
            bottomBar = {
                NexusBottomAppBar(
                    onHome = { navController.navigate(Dest.Home.route) },
                    onGames = { navController.navigate(Dest.Games.route) },
                    onNewsAndPopular = { navController.navigate(Dest.NewsAndPopular.route) },
                    onMyNexus = { navController.navigate(Dest.MyNexus.route) },
                )
            }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = Dest.Home.route,
                modifier = modifier.padding(innerPadding)
            ) {
                composable(route = Dest.Series.route) {

                }

                composable(route = Dest.SeriesDetail.route) {

                }

                composable(route = Dest.Movies.route) {

                }

                composable(route = Dest.MovieDetail.route) {

                }

                composable(route = Dest.Categories.route) {

                }

                composable(route = Dest.Search.route) {

                }

                composable(route = Dest.Home.route) {

                }

                composable(route = Dest.Games.route) {

                }

                composable(route = Dest.NewsAndPopular.route) {

                }

                composable(route = Dest.MyNexus.route) {

                }
            }
        }
    }
}


