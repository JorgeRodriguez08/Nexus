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
    import com.example.nexus.ui.samples.Samples
    import com.example.nexus.ui.screen.home.HomeScreen
    import com.example.nexus.ui.screen.mynexus.MyNexusScreen
    import com.example.nexus.ui.screen.news.NewsScreen
    import com.example.nexus.ui.screen.popular.PopularScreen
    import com.example.nexus.ui.screen.search.SearchScreen
    import com.example.nexus.ui.theme.NexusTheme

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun NexusNavHost(
        navController: NavHostController,
        modifier: Modifier = Modifier
    ) {
        Scaffold(
            topBar = {
                NexusTopAppBar(
                    onSearchClick = { navController.navigate(NexusDestination.Search.route) },
                    onBackClick = { navController.popBackStack() },
                    onDownloadClick = { navController.navigate(NexusDestination.MyNexus.route) }
                )
            },
            bottomBar = {
                NexusBottomAppBar(
                    onHome = { navController.navigate(NexusDestination.Home.route) },
                    onNews = { navController.navigate(NexusDestination.News.route) },
                    onPopular = { navController.navigate(NexusDestination.Popular.route) },
                    onMyNexus = { navController.navigate(NexusDestination.MyNexus.route) },
                )
            }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = NexusDestination.Home.route,
                modifier = modifier.padding(innerPadding)
            ) {
                composable(route = NexusDestination.Home.route) {
                    HomeScreen(movie = Samples.movie, movies = Samples.movies)
                }

                composable(route = NexusDestination.News.route) {
                    NewsScreen(movie = Samples.movie, movies = Samples.movies)
                }

                composable(route = NexusDestination.Popular.route) {
                    PopularScreen(movie = Samples.movie, movies = Samples.movies)
                }

                composable(route = NexusDestination.MyNexus.route) {
                    MyNexusScreen(movie = Samples.movie, movies = Samples.movies)
                }

                composable(route = NexusDestination.Search.route) {
                    SearchScreen(movie = Samples.movie, movies = Samples.movies)
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


