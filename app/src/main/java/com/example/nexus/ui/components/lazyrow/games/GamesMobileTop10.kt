package com.example.nexus.ui.components.lazyrow.games

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.nexus.domain.model.Movie
import com.example.nexus.ui.components.card.game.GameMobileTop
import com.example.nexus.ui.theme.Dimens
import com.example.nexus.ui.theme.FontSizes
import com.example.nexus.ui.theme.Strings

@Composable
fun GamesMobileTop10(
    games: List<Movie>,
    onMovieClick: (Int) -> Unit,
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
            text = Strings.Games.gamesMobileTop10,
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = FontSizes.bodyLarge,
            fontWeight = FontWeight.ExtraBold
        )

        Spacer(modifier = Modifier.height(Dimens.Padding.extraSmall))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(Dimens.Padding.base)
        ) {
            itemsIndexed(games.take(10)) { index, game ->
                GameMobileTop(
                    game = game,
                    index = index + 1,
                    onMovieClick = onMovieClick
                )
            }
        }
    }
}