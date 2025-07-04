package com.example.nexus.ui.composables.lazyrow

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.nexus.domain.model.Movie
import com.example.nexus.ui.composables.card.NexusCardSmall
import com.example.nexus.ui.navigation.NexusNavHost
import com.example.nexus.ui.theme.NexusTheme

@Composable
fun NexusLazyRowSmall(
    movies: List<Movie>,
    modifier: Modifier = Modifier,
    title: String,
    itemWidth: Dp = 110.dp,
    itemHeight: Dp = 150.dp
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.SemiBold,
            maxLines = 2,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 8.dp, end = 25.dp)
        )

        LazyRow(
            modifier = modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(movies, key = {it.id}) { movie ->
                NexusCardSmall(
                    movie = movie,
                    modifier = modifier
                        .width(itemWidth)
                        .height(itemHeight)
                )
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