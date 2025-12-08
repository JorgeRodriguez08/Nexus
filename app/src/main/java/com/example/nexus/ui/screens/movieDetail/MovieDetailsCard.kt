package com.example.nexus.ui.screens.movieDetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import coil.compose.AsyncImage
import com.example.nexus.domain.models.MovieDetails
import com.example.nexus.ui.components.buttons.ButtonExtraLarge
import com.example.nexus.ui.theme.Dimens
import com.example.nexus.ui.theme.FontSize
import com.example.nexus.ui.theme.LabelButton
import com.example.nexus.ui.theme.TitleScreen

@Composable
fun MovieDetailCard(
    movieDetails: MovieDetails,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = Dimens.Padding.standard)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(Dimens.Padding.extraSmall),
        horizontalAlignment = Alignment.Start
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(Dimens.AspectRatio.SMALL),
            shape = RectangleShape
        ) {
            AsyncImage(
                model = movieDetails.movie.backdropUrl,
                contentDescription = movieDetails.movie.title,
                modifier = Modifier.fillMaxSize(),
                alignment = Alignment.TopCenter,
                contentScale = ContentScale.Crop
            )
        }

        Text(
            text = movieDetails.movie.title,
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = FontSize.extraLarge,
            fontWeight = FontWeight.ExtraBold
        )

        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.spacedBy(Dimens.Spacing.extraLarge),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = movieDetails.movie.releaseDate.substring(0, 4),
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontSize = FontSize.small
            )

            Card(
                modifier = Modifier
                    .height(Dimens.IconSize.extraSmall)
                    .wrapContentWidth(),
                shape = RectangleShape
            ) {
                Column(
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = if (movieDetails.movie.adult) TitleScreen.FOR_ADULTS else TitleScreen.FOR_KIDS,
                        color = MaterialTheme.colorScheme.onSecondaryContainer,
                        fontSize = FontSize.small
                    )
                }
            }

            Text(
                text = "${movieDetails.movie.runtime / 60} h ${movieDetails.movie.runtime % 60} min",
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontSize = FontSize.small
            )
        }

        ButtonExtraLarge(
            label = LabelButton.WATCH,
            enabled = true,
            modifier = modifier
        )

        ButtonExtraLarge(
            label = LabelButton.DOWNLOAD,
            enabled = false,
            modifier = modifier
        )

        Spacer(modifier = Modifier.height(Dimens.Spacing.compact))

        Text(
            text = movieDetails.movie.overview,
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = FontSize.compact,
            lineHeight = FontSize.base,
            maxLines = 4
        )

        Text(
            text = TitleScreen.CAST + movieDetails.cast.joinToString(", ") { it.name },
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = FontSize.extraSmall,
            lineHeight = FontSize.base,
            maxLines = 2
        )

        val director = movieDetails.crew.find { it.job == TitleScreen.DIRECTOR }?.name ?: TitleScreen.UNKNOWN

        Text(
            text = TitleScreen.DIRECTION + director,
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = FontSize.extraSmall,
            maxLines = 1
        )
    }
}