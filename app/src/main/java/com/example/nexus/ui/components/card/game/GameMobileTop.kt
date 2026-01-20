package com.example.nexus.ui.components.card.game

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import coil.compose.SubcomposeAsyncImage
import com.example.nexus.domain.model.Movie
import com.example.nexus.ui.shimmer.ShimmerDarkBox
import com.example.nexus.ui.theme.Dimens
import com.example.nexus.ui.theme.FontSizes

@Composable
fun GameMobileTop(
    game: Movie,
    index: Int,
    onMovieClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.Top
    ) {
        Box(
            modifier = Modifier
                .clickable(onClick = { onMovieClick(game.id) })
                .width(Dimens.Box.small.width)
                .offset(x = Dimens.Padding.medium),
            contentAlignment = Alignment.BottomStart
        ) {
            Text(
                text = index.toString().substring(0,1),
                modifier = Modifier.padding(),
                style = TextStyle(
                    color = Color.White,
                    fontSize = FontSizes.displayLarge,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Default,
                    drawStyle = Stroke(width = 2f)
                ),
                maxLines = 1
            )
        }

        Column(
            modifier = modifier.width(Dimens.Posters.extraSmall.width),
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
                    color = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = Dimens.Alpha.regular)
                ),
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
}