package com.example.nexus.ui.components.card.game

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
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
import coil.compose.SubcomposeAsyncImage
import com.example.nexus.domain.model.Movie
import com.example.nexus.ui.shimmer.ShimmerDarkBox
import com.example.nexus.ui.theme.Dimens
import com.example.nexus.ui.theme.FontSizes

@Composable
fun GameMobile(
    game: Movie,
    onMovieClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clickable(onClick = { onMovieClick(game.id) })
            .width(Dimens.Posters.extraSmall.width),
        horizontalAlignment = Alignment.Start
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(Dimens.Posters.extraSmall.height),
            shape = RoundedCornerShape(Dimens.Radius.large),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.background
            ),
            border = BorderStroke(
                width = Dimens.Borders.hairline,
                color = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = Dimens.Alpha.regular))
        ) {
            SubcomposeAsyncImage(
                model = game.posterUrl,
                contentDescription = game.title,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                loading = {
                    ShimmerDarkBox(
                        width = Dimens.Posters.extraSmall.width,
                        height = Dimens.Posters.extraSmall.height,
                        cornerRadius = Dimens.Radius.large
                    )
                }
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
            text = game.releaseDate.substring(0,4),
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = FontSizes.labelMedium
        )
    }
}