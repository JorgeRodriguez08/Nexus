package com.example.nexus.ui.composables.body

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.nexus.domain.model.Movie
import com.example.nexus.ui.composables.card.NexusCard
import com.example.nexus.ui.composables.lazyrow.NexusLazyRowSmall
import com.example.nexus.ui.navigation.NexusNavHost
import com.example.nexus.ui.samples.Samples
import com.example.nexus.ui.samples.Samples.Section
import com.example.nexus.ui.theme.NexusTheme


@Composable
fun NexusBody(
    movies: List<Movie>,
    categories: List<Section> = Samples.categories,
    movie: Movie,
    modifier: Modifier
) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
            .fillMaxSize()
    ) {
        items(categories) { category ->
            when (category) {
                Samples.categories.first() -> NexusCard(movie = movie)
                Samples.categories[1],Samples.categories[2] -> NexusLazyRowSmall(
                    movies = Samples.movies, title = category.title,modifier = modifier,
                    itemHeight = 110.dp, itemWidth = 110.dp
                )

                Samples.categories[4] -> NexusLazyRowSmall(
                    movies = Samples.movies, title = category.title,modifier = modifier,
                    itemHeight = 290.dp, itemWidth = 170.dp
                )

                Samples.categories[5] -> NexusLazyRowSmall(
                    movies = Samples.movies, title = category.title,modifier = modifier,
                    itemHeight = 330.dp, itemWidth = 195.dp
                )

                Samples.categories[21] -> NexusLazyRowSmall(
                    movies = Samples.movies, title = category.title,modifier = modifier,
                    itemHeight = 150.dp, itemWidth = 220.dp
                )

                else -> NexusLazyRowSmall(movies = Samples.movies, title = category.title,modifier = modifier)
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
fun PreviewNexusBody() {
    NexusTheme{
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            NexusNavHost(rememberNavController())
        }
    }
}