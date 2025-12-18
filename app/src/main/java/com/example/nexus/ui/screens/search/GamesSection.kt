package com.example.nexus.ui.screens.search

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.nexus.domain.model.Movie

@Composable
fun GamesSection(
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
            fontSize = 18.sp,
            fontWeight = FontWeight.ExtraBold,
            color = MaterialTheme.colorScheme.onSurface
        )

        Spacer(modifier = Modifier.height(4.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(9.dp)
        ) {
            items(games) { game ->
                GameRecommended(
                    game = game
                )
            }
        }
    }
}


@Composable
fun GameRecommended(
    game: Movie,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = modifier.width(113.dp)
    ) {
        Card(
            shape = RoundedCornerShape(13.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.background
            ),
            border = BorderStroke(
                width = 1.dp,
                color = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.3f)),
            modifier = Modifier
                .height(113.dp)
                .fillMaxWidth(),
        ) {
            AsyncImage(
                model = game.posterUrl,
                contentDescription = "Game Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

        }

        Spacer(modifier = Modifier.height(4.dp))

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