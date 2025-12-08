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
import com.example.nexus.domain.models.Serie
import com.example.nexus.ui.components.buttons.ButtonLarge
import com.example.nexus.ui.theme.Dimens
import com.example.nexus.ui.theme.LabelButton

@Composable
fun SerieCardLarge(
    serie: Serie,
    modifier: Modifier = Modifier,
    onSerieClick: (Int) -> Unit
) {
    val posterLarge = Dimens.Poster.large
    Card(
        modifier = modifier
            .width(posterLarge.width)
            .height(posterLarge.height)
            .clickable(onClick = { onSerieClick(serie.id) }),
        border =  BorderStroke(Dimens.Border.small, MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = Dimens.Alpha.SMALL)),
        elevation = CardDefaults.cardElevation(Dimens.Elevation.medium),
        shape = RoundedCornerShape(Dimens.Radius.medium)
    ) {
        Box {
            AsyncImage(
                model = serie.posterUrl,
                contentDescription = serie.title,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.surfaceContainerHigh),
                alignment = Alignment.Center
            )

            Row(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = Dimens.Padding.base),
                horizontalArrangement = Arrangement.spacedBy(Dimens.Spacing.jumbo)
            ) {

                ButtonLarge(
                    label = LabelButton.PLAY,
                    imageVector = Icons.Filled.PlayArrow,
                    enabled = true,
                    onClick = {  },
                    color = MaterialTheme.colorScheme.surface,
                    modifier = Modifier
                )

                ButtonLarge(
                    label = LabelButton.MY_LIST,
                    imageVector = Icons.Filled.Add,
                    enabled = false,
                    onClick = {  },
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier
                )
            }
        }
    }
}
