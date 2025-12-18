package com.example.nexus.ui.components.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import com.example.nexus.domain.model.Movie
import com.example.nexus.ui.components.buttons.ButtonMedium
import com.example.nexus.ui.theme.Dimens
import com.example.nexus.ui.theme.Strings

@Composable
fun MovieCardLarge(
    movie: Movie,
    onMovieClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val posterLarge = Dimens.Posters.large
    Card(
        modifier = modifier
            .width(posterLarge.width)
            .height(posterLarge.height)
            .clickable(onClick = { onMovieClick(movie.id) }),
        shape = RoundedCornerShape(Dimens.Radius.large),
        elevation = CardDefaults.cardElevation(Dimens.Elevation.extraLarge),
        border =  BorderStroke(Dimens.Borders.hairline, MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = Dimens.Alpha.disabled)),
    ) {
        Box {
            AsyncImage(
                model = movie.posterUrl,
                contentDescription = movie.title,
                modifier = modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.surfaceContainerHigh),
                alignment = Alignment.Center,
                contentScale = ContentScale.Crop,
            )

            Row(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = Dimens.Padding.large),
                horizontalArrangement = Arrangement.spacedBy(Dimens.Padding.extraExtraLarge)
            ) {
                ButtonMedium(
                    label = Strings.Labels.play,
                    onClick = {  },
                    enabled = true,
                    imageVector = Icons.Filled.PlayArrow,
                    color = MaterialTheme.colorScheme.surface
                )

                ButtonMedium(
                    label = Strings.Labels.myList,
                    onClick = {  },
                    enabled = false,
                    imageVector = Icons.Filled.Add,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}