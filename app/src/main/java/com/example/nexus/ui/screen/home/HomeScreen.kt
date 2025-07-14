package com.example.nexus.ui.screen.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nexus.ui.composables.card.MovieCardLarge
import com.example.nexus.ui.composables.lazyrow.MoviesLazyRow
import com.example.nexus.ui.composables.lazyrow.SeriesLazyRow
import com.example.nexus.ui.samples.Samples
import com.example.nexus.ui.theme.NexusTheme
import org.koin.androidx.compose.koinViewModel

@Composable
    fun HomeScreen(
        viewModel: HomeViewModel,
        modifier: Modifier = Modifier
    ) {
        val uiState = viewModel.uiState.collectAsState()
        val featuredMovieState = viewModel.featuredMovie.collectAsState()
        val featuredMovie = featuredMovieState.value

        LazyColumn(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                MovieCardLarge(movie = featuredMovie ?: Samples.movie)
            }

            items(homeCategories) { category ->
                if (category.isMovie) {
                    val movieState = uiState.value.movieState[category]
                    if (movieState != null && movieState.items.isNotEmpty()) {
                        MoviesLazyRow(category.title, movieState.items)
                    }

                } else if (category.isSeries) {
                    val seriesState = uiState.value.seriesState[category]
                    if (seriesState != null && seriesState.items.isNotEmpty()) {
                        SeriesLazyRow(category.title, seriesState.items)
                    }
                }
            }
        }
    }

    @Preview (
        showBackground = true,
        showSystemUi = true,
        uiMode = Configuration.UI_MODE_NIGHT_YES
    )
    @Composable
    fun PreviewHomeScreen() {
        NexusTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                val homeViewModel: HomeViewModel = koinViewModel()
                HomeScreen(
                    viewModel = homeViewModel
                )
            }
        }
    }