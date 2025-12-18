package com.example.nexus.ui.components.lazyrow

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import coil.compose.AsyncImage
import com.example.nexus.domain.model.Movie
import com.example.nexus.ui.theme.Dimens
import com.example.nexus.ui.theme.FontSizes
import com.example.nexus.ui.theme.Strings

@Composable
fun GamesMobileRecommended(
    games: List<Movie>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = Dimens.Padding.extraSmall)
    ) {
        Text(
            text = Strings.Games.gamesMobileRecommended,
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = FontSizes.bodyLarge,
            fontWeight = FontWeight.ExtraBold
        )

        Spacer(modifier = Modifier.height(Dimens.Padding.extraSmall))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(Dimens.Padding.base)
        ) {
            items(games) { game ->
                GameMobile(
                    game = game
                )
            }
        }
    }
}

@Composable
fun GameMobile(
    game: Movie,
    modifier: Modifier = Modifier
) {
    val postersSmall = Dimens.Posters.small
    Column(
        modifier = modifier.width(postersSmall.width),
        horizontalAlignment = Alignment.Start
    ) {
        Card(
            modifier = Modifier
                .height(postersSmall.height)
                .fillMaxWidth(),
            shape = RoundedCornerShape(Dimens.Radius.large),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.background
            ),
            border = BorderStroke(
                width = Dimens.Borders.hairline,
                color = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = Dimens.Alpha.regular)),

            ) {
            AsyncImage(
                model = game.posterUrl,
                contentDescription = game.title,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(Dimens.Padding.small))

        Text(
            text = game.title,
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = FontSizes.labelMedium,
            fontWeight = FontWeight.ExtraBold,
            lineHeight = FontSizes.bodySmall,
            maxLines = 2
        )

        Text(
            text = game.releaseDate,
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = FontSizes.labelMedium
        )
    }
}