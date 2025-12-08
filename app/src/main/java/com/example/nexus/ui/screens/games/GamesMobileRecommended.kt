package com.example.nexus.ui.screens.games

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
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import coil.compose.AsyncImage
import com.example.nexus.R
import com.example.nexus.domain.models.Movie
import com.example.nexus.ui.theme.FontSize

@Composable
fun GamesMobileRecommended(
    games: List<Movie>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = dimensionResource(R.dimen.padding_3dp))
    ) {
        Text(
            text = "Juegos móviles recomendados",
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = FontSize.size_17_5sp,
            fontWeight = FontWeight.ExtraBold
        )

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.space_4dp)))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.space_9dp))
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
    Column(
        modifier = modifier.width(dimensionResource(R.dimen.size_116dp)),
        horizontalAlignment = Alignment.Start
    ) {
        Card(
            modifier = Modifier
                .height(dimensionResource(R.dimen.size_116dp))
                .fillMaxWidth(),
            shape = RoundedCornerShape(dimensionResource(R.dimen.rounded_13dp)),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.background
            ),
            border = BorderStroke(
                width = dimensionResource(R.dimen.border_1dp),
                color = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.3f)),

        ) {
            AsyncImage(
                model = game.posterUrl,
                contentDescription = game.title,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.space_6dp)))

        Text(
            text = game.title,
            fontSize = FontSize.size_11sp,
            fontWeight = FontWeight.ExtraBold,
            maxLines = 2,
            lineHeight = FontSize.size_14sp,
            color = MaterialTheme.colorScheme.onSurface
        )

        Text(
            text = game.releaseDate,
            fontSize = FontSize.size_11sp,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}