package com.example.nexus.ui.components.card.serie

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.nexus.domain.model.SerieIntegrated
import com.example.nexus.ui.components.buttons.ButtonDropDown
import com.example.nexus.ui.components.buttons.ButtonLarge
import com.example.nexus.ui.screens.serieDetails.SeasonDetailsState
import com.example.nexus.ui.theme.Dimens
import com.example.nexus.ui.theme.FontSizes
import com.example.nexus.ui.theme.Strings

@Composable
fun SerieDetailsCard(
    serieIntegrated: SerieIntegrated,
    selectedSeasonNumber: Int,
    onSeasonClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = Dimens.Padding.base),
        verticalArrangement = Arrangement.spacedBy(Dimens.Padding.extraSmall),
        horizontalAlignment = Alignment.Start
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(Dimens.AspectRatio.poster),
            shape = RectangleShape
        ) {
            AsyncImage(
                model = serieIntegrated.serieDetails.backdropUrl,
                contentDescription = serieIntegrated.serieDetails.title,
                modifier = Modifier.fillMaxSize(),
                alignment = Alignment.TopCenter,
                contentScale = ContentScale.Crop
            )
        }

        Text(
            text = serieIntegrated.serieDetails.title,
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = FontSizes.titleLarge,
            fontWeight = FontWeight.Black,
            lineHeight = FontSizes.titleLarge,
            maxLines = 2
        )

        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.spacedBy(Dimens.Padding.extraExtraLarge),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = serieIntegrated.serieDetails.firstAirDate.substring(0, 4),
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontSize = FontSizes.labelMedium
            )

            Card(
                modifier = Modifier
                    .width(Dimens.Box.extraSmall.width)
                    .height(Dimens.Box.extraSmall.height),
                shape = RectangleShape
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text =
                            if (serieIntegrated.serieDetails.adult)
                                Strings.Badges.adults
                            else
                                Strings.Badges.kids,
                        color = MaterialTheme.colorScheme.onSecondaryContainer,
                        fontSize = FontSizes.labelMedium,
                        fontWeight = FontWeight.ExtraBold
                    )
                }
            }

            Text(
                text =
                    if (!serieIntegrated.serieDetails.episodeRuntime.isEmpty())
                        "${serieIntegrated.serieDetails.episodeRuntime.first() / 60} h ${serieIntegrated.serieDetails.episodeRuntime.first() % 60} min"
                    else
                        "${60 / 60} h ${60 % 60} min",
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontSize = FontSizes.labelMedium
            )
        }

        ButtonLarge(
            label = Strings.Labels.watch,
            enabled = true,
            modifier = modifier
        )

        ButtonLarge(
            label = Strings.Labels.download,
            enabled = false,
            modifier = modifier
        )

        Spacer(modifier = Modifier.height(Dimens.Padding.medium))

        Text(
            text =
                if (serieIntegrated.serieDetails.overview.isNotEmpty())
                    serieIntegrated.serieDetails.overview
                else
                    "${serieIntegrated.serieDetails.title}. ${serieIntegrated.serieDetails.firstAirDate}",
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = FontSizes.bodySmall,
            lineHeight = FontSizes.bodyMedium,
            maxLines = 4,
            overflow = TextOverflow.Ellipsis
        )

        Text(
            text = Strings.Labels.cast + serieIntegrated.cast.joinToString(", ") { it.name },
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = FontSizes.labelMedium,
            lineHeight = FontSizes.bodyMedium,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )

        val director = serieIntegrated.crew.find { it.job == Strings.Labels.director }?.name
            ?: Strings.Labels.unknownDirector

        Text(
            text = Strings.Labels.direction + director,
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = FontSizes.labelMedium,
            maxLines = 1
        )

        Spacer(modifier = Modifier.height(8.dp))

        ButtonDropDown(
            seasons = serieIntegrated.serieDetails.seasons,
            selectedSeasonNumber = selectedSeasonNumber,
            onSeasonClick = onSeasonClick,
        )
    }
}