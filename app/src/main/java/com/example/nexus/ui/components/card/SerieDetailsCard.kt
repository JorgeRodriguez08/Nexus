package com.example.nexus.ui.components.card

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
import com.example.nexus.domain.model.SerieDetails
import com.example.nexus.ui.components.buttons.ButtonLarge
import com.example.nexus.ui.theme.Dimens
import com.example.nexus.ui.theme.FontSizes
import com.example.nexus.ui.theme.Strings

@Composable
fun SerieDetailsCard(
    serieDetails: SerieDetails,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = Dimens.Padding.base)
            .verticalScroll(rememberScrollState()),
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
                model = serieDetails.serie.backdropUrl,
                contentDescription = serieDetails.serie.title,
                modifier = Modifier.fillMaxSize(),
                alignment = Alignment.TopCenter,
                contentScale = ContentScale.Crop
            )
        }

        Text(
            text = serieDetails.serie.title,
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = FontSizes.titleLarge,
            fontWeight = FontWeight.ExtraBold
        )

        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.spacedBy(Dimens.Padding.extraExtraLarge),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = serieDetails.serie.firstAirDate.substring(0, 4),
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontSize = FontSizes.labelMedium
            )

            Card(
                modifier = Modifier
                    .height(Dimens.Icons.small)
                    .wrapContentWidth(),
                shape = RectangleShape
            ) {
                Column(
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text =
                            if (serieDetails.serie.adult)
                                Strings.Badges.adults
                            else
                                Strings.Badges.kids,
                        color = MaterialTheme.colorScheme.onSecondaryContainer,
                        fontSize = FontSizes.labelMedium
                    )
                }
            }

            Text(
                text = "${120 / 60} h ${120 % 60} min",
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
            text = serieDetails.serie.overview,
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = FontSizes.bodySmall,
            lineHeight = FontSizes.bodyMedium,
            maxLines = 4
        )

        Text(
            text = Strings.Labels.cast + serieDetails.cast.joinToString(", ") { it.name },
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = FontSizes.labelMedium,
            lineHeight = FontSizes.bodyMedium,
            maxLines = 2
        )

        val director = serieDetails.crew.find { it.job == Strings.Labels.director }?.name
            ?: Strings.Labels.unknown

        Text(
            text = Strings.Labels.direction + director,
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = FontSizes.labelMedium,
            maxLines = 1
        )
    }
}