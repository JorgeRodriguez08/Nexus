package com.example.nexus.ui.screens.games

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
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.nexus.R
import com.example.nexus.domain.models.Movie
import com.example.nexus.ui.theme.FontSize

@Composable
fun GamesMobileTop10(
    games: List<Movie>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = dimensionResource(R.dimen.padding_3dp))
    ) {
        Text(
            text = "Los 10 Juegos móviles más populares",
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = FontSize.size_17_5sp,
            fontWeight = FontWeight.ExtraBold
        )

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.space_4dp)))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.space_9dp))
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
        modifier = Modifier.width(dimensionResource(R.dimen.size_155dp))
    ) {
        Text(
            text = index.toString(),
            modifier = Modifier
                .align(Alignment.BottomStart)
                .offset(x = 0.dp, y = -42.dp),
            style = TextStyle(
                fontSize = FontSize.size_100sp,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                drawStyle = Stroke(width = 2f)
            )
        )

        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.align(Alignment.CenterEnd)
        ) {
            Card(
                modifier = Modifier
                    .height(dimensionResource(R.dimen.size_116dp))
                    .width(dimensionResource(R.dimen.size_116dp)),
                shape = RoundedCornerShape(dimensionResource(R.dimen.rounded_13dp)),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.background
                ),
                border = BorderStroke(
                    width = dimensionResource(R.dimen.border_1dp),
                    color = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.3f)
                ),
            ) {
                AsyncImage(
                    model = game.posterUrl,
                    contentDescription = game.title,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop,
                )
            }

            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.space_6dp)))

            Text(
                text = game.title,
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = FontSize.size_11sp,
                fontWeight = FontWeight.ExtraBold,
                lineHeight = FontSize.size_14sp,
                maxLines = 2
            )

            Text(
                text = game.releaseDate,
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = FontSize.size_11sp
            )
        }
    }
}