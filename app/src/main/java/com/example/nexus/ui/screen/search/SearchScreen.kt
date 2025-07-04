package com.example.nexus.ui.screen.search

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.nexus.domain.model.Movie
import com.example.nexus.ui.composables.body.NexusBody
import com.example.nexus.ui.samples.Samples
import com.example.nexus.ui.theme.NexusTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    movies: List<Movie>,
    movie: Movie,
    modifier: Modifier = Modifier
) {
    NexusBody(
        modifier = modifier,
        movie = movie,
        movies = movies
    )
}

@Preview (
    showBackground = true,
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun SearchPreview() {
    NexusTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            SearchScreen(
                movie = Samples.movie,
                movies = Samples.movies
            )
        }
    }
}