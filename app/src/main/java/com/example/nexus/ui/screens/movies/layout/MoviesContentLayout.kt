package com.example.nexus.ui.screens.movies.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.nexus.domain.model.Movie
import com.example.nexus.ui.components.card.MovieCardLarge
import com.example.nexus.ui.components.lazyrow.MoviesLazyRow
import com.example.nexus.ui.components.shimmer.MoviesCardLargeShimmer
import com.example.nexus.ui.components.shimmer.MoviesRowShimmer
import com.example.nexus.ui.screens.movies.MoviesCategory
import com.example.nexus.ui.screens.movies.MoviesState

@Composable
fun MoviesContentLayout(
    featuredState: MoviesState,
    moviesUiState: Map<MoviesCategory, MoviesState>,
    categories: List<MoviesCategory>,
    onMovieClick: (Int) -> Unit,
    modifier: Modifier
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(top = 50.dp),
    ) {
        item {
            when (featuredState) {
                is MoviesState.Loading -> { MoviesCardLargeShimmer() }
                is MoviesState.Success -> {
                    val featured = featuredState.results.first()
                    MovieCardLarge(featured, onMovieClick = onMovieClick)
                }
                is MoviesState.Error -> { MoviesCardLargeShimmer() }
            }
        }

        items(categories) { category ->
            val moviesState = moviesUiState[category]
            when (moviesState) {
                null, is MoviesState.Loading -> { MoviesRowShimmer(category.title) }
                is MoviesState.Success -> { MoviesLazyRow(category.title, moviesState.results, onMovieClick = onMovieClick) }
                is MoviesState.Error -> { MoviesRowShimmer(category.title) }
            }
        }
    }
}