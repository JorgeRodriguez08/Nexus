package com.example.nexus.ui.shimmer.card.serie

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
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
import com.example.nexus.ui.components.buttons.ButtonMedium
import com.example.nexus.ui.shimmer.ShimmerDarkBox
import com.example.nexus.ui.theme.Dimens
import com.example.nexus.ui.theme.Strings

@Composable
fun SerieCardLargeShimmer(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .width(Dimens.Posters.extraLarge.width)
            .height(Dimens.Posters.extraLarge.height),
        shape = RoundedCornerShape(Dimens.Radius.large),
        elevation = CardDefaults.cardElevation(Dimens.Elevation.extraLarge),
        border =  BorderStroke(Dimens.Borders.hairline, MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = Dimens.Alpha.disabled)),
    ) {
        Box {
            ShimmerDarkBox(
                width = Dimens.Posters.extraLarge.width,
                height = Dimens.Posters.extraLarge.height,
                cornerRadius = Dimens.Radius.large,
                modifier = modifier
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