package com.example.nexus.ui.screens.games

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.R
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.nexus.domain.model.Movie
import org.koin.core.definition.indexKey


@Composable
fun GamesTop10Section(
    games: List<Movie>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 3.dp)
    ) {
        Text(
            text = "Juegos móviles recomendados",
            fontSize = 17.5.sp,
            fontWeight = FontWeight.ExtraBold,
            color = MaterialTheme.colorScheme.onSurface
        )

        Spacer(modifier = Modifier.height(4.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(9.dp)
        ) {
            items(games) { game ->
                GameTopRecommended(
                    game = game,
                    index = 1 + games.indexOf(game)
                )
            }
        }
    }
}


@Composable
fun GameTopRecommended(
    game: Movie,
    index: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier.width(155.dp)
    ) {
        Text(
            text = index.toString(),
            style = TextStyle(
                fontSize = 100.sp,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                drawStyle = Stroke(width = 2f)
            ),
            modifier = Modifier
                .align(Alignment.BottomStart)
                .offset(x = 0.dp, y = -42.dp)
        )


        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.align(Alignment.CenterEnd)
        ) {
            Card(
                shape = RoundedCornerShape(13.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.background
                ),
                border = BorderStroke(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.3f)
                ),
                modifier = Modifier
                    .height(116.dp)
                    .width(116.dp),
            ) {
                AsyncImage(
                    model = game.posterUrl,
                    contentDescription = "Game Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

            }

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = game.title,
                fontSize = 11.sp,
                fontWeight = FontWeight.ExtraBold,
                maxLines = 2,
                lineHeight = 14.sp,
                color = MaterialTheme.colorScheme.onSurface
            )

            Text(
                text = game.releaseDate,
                fontSize = 11.sp,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}