package com.example.nexus.ui.shimmer.lazyrow.movies

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.nexus.ui.shimmer.card.movie.MovieTopShimmer
import com.example.nexus.ui.theme.Dimens
import com.example.nexus.ui.theme.FontSizes

@Composable
fun MoviesTop10LazyRowShimmer(
    title: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                top = Dimens.Padding.extraSmall,
                start = Dimens.Padding.large
            )
    ) {
        Text(
            text = title,
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = FontSizes.bodyLarge,
            fontWeight = FontWeight.ExtraBold
        )

        Spacer(modifier = Modifier.height(Dimens.Padding.extraSmall))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(Dimens.Padding.base)
        ) {
            items(10) { index ->
                MovieTopShimmer(
                    index = index + 1
                )
            }
        }
    }
}