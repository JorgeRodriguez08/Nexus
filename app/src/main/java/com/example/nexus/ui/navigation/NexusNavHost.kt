    package com.example.nexus.ui.navigation

    import android.content.res.Configuration
    import androidx.compose.foundation.layout.fillMaxSize
    import androidx.compose.foundation.layout.padding
    import androidx.compose.material3.ExperimentalMaterial3Api
    import androidx.compose.material3.MaterialTheme
    import androidx.compose.material3.Scaffold
    import androidx.compose.material3.Surface
    import androidx.compose.runtime.Composable
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.tooling.preview.Preview
    import androidx.navigation.NavHostController
    import androidx.navigation.compose.NavHost
    import androidx.navigation.compose.composable
    import androidx.navigation.compose.rememberNavController
    import com.example.nexus.ui.composables.bottomappbar.NexusBottomAppBar
    import com.example.nexus.ui.composables.topappbar.NexusTopAppBar
    import com.example.nexus.ui.screen.home.HomeScreen
    import com.example.nexus.ui.screen.home.HomeViewModel
    import com.example.nexus.ui.theme.NexusTheme
    import org.koin.androidx.compose.koinViewModel

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun NexusNavHost(
        navController: NavHostController,
        modifier: Modifier = Modifier
    ) {
        Scaffold(
            topBar = {
                NexusTopAppBar(
                    onSearchClick = { navController.navigate(NexusScreen.Search.route) },
                    onBackClick = { navController.popBackStack() },
                    onDownloadClick = { navController.navigate(NexusScreen.MyNexus.route) }
                )
            },
            bottomBar = {
                NexusBottomAppBar(
                    onHome = { navController.navigate(NexusScreen.Home.route) },
                    onNews = { navController.navigate(NexusScreen.News.route) },
                    onPopular = { navController.navigate(NexusScreen.Popular.route) },
                    onMyNexus = { navController.navigate(NexusScreen.MyNexus.route) },
                )
            }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = NexusScreen.Home.route,
                modifier = modifier.padding(innerPadding)
            ) {
                composable(route = NexusScreen.Home.route) {
                    val homeViewModel: HomeViewModel = koinViewModel()
                    HomeScreen(homeViewModel)
                }

                composable(route = NexusScreen.News.route) {
                   /* NewsScreen(movie = Samples.movie, movies = Samples.movies)*/
                }

                composable(route = NexusScreen.Popular.route) {
                    /*PopularScreen(movie = Samples.movie, movies = Samples.movies)*/
                }

                composable(route = NexusScreen.MyNexus.route) {
                    /*MyNexusScreen(movie = Samples.movie, movies = Samples.movies)*/
                }

                composable(route = NexusScreen.Search.route) {
                    /*SearchScreen(movie = Samples.movie, movies = Samples.movies)*/
                }
            }
        }
    }

    @Preview(
        showBackground = true,
        showSystemUi = true,
        uiMode = Configuration.UI_MODE_NIGHT_YES
    )
    @Composable
    fun PreviewNexusNavHost() {
        NexusTheme{
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                NexusNavHost(rememberNavController())
            }
        }
    }


