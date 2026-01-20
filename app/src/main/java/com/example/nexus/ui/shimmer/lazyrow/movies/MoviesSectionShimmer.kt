package com.example.nexus.ui.shimmer.lazyrow.movies

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.nexus.ui.shimmer.card.movie.MovieRecommendedShimmer
import com.example.nexus.ui.theme.Dimens
import com.example.nexus.ui.theme.FontSizes
import com.example.nexus.ui.theme.Strings

@Composable
fun MoviesSectionShimmer(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(Dimens.Padding.medium)
    ) {
        Text(
            text = Strings.Search.serieAndMoviesRecommended,
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = FontSizes.bodyLarge,
            fontWeight = FontWeight.ExtraBold
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(Dimens.Padding.medium)
        ) {
            List(20) { it + 1 }.forEach { it ->
                MovieRecommendedShimmer(
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}