package com.example.nexus.ui.components.lazyrow

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.nexus.domain.model.Movie
import com.example.nexus.ui.theme.Dimens
import com.example.nexus.ui.theme.FontSizes
import com.example.nexus.ui.theme.Strings

@Composable
fun GamesMobileTop10(
    games: List<Movie>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = Dimens.Padding.extraSmall)
    ) {
        Text(
            text = Strings.Games.gamesMobileTop10,
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = FontSizes.bodyLarge,
            fontWeight = FontWeight.ExtraBold
        )

        Spacer(modifier = Modifier.height(Dimens.Padding.extraSmall))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(Dimens.Padding.base)
        ) {
            items(games) { game ->
                GameMobileTop(
                    game = game,
                    index = games.indexOf(game) + 1
                )
            }
        }
    }
}

@Composable
fun GameMobileTop(
    game: Movie,
    index: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier.width(Dimens.Posters.regular.width)
    ) {
        Text(
            text = index.toString(),
            modifier = Modifier
                .align(Alignment.BottomStart)
                .offset(x = 0.dp, y = -42.dp),
            style = TextStyle(
                color = Color.White,
                fontSize = FontSizes.displayLarge,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Default,
                drawStyle = Stroke(width = 2f)
            )
        )

        val postersSmall = Dimens.Posters.small
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.align(Alignment.CenterEnd)
        ) {
            Card(
                modifier = Modifier
                    .width(postersSmall.width)
                    .height(postersSmall.height)
                ,
                shape = RoundedCornerShape(Dimens.Radius.large),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.background
                ),
                border = BorderStroke(
                    width = Dimens.Borders.hairline,
                    color = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = Dimens.Alpha.regular)
                ),
            ) {
                AsyncImage(
                    model = game.posterUrl,
                    contentDescription = game.title,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop,
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
}