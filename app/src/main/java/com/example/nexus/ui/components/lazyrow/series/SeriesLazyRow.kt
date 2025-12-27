package com.example.nexus.ui.components.lazyrow.series

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.nexus.domain.model.Serie
import com.example.nexus.ui.components.card.serie.SerieCardSmall
import com.example.nexus.ui.theme.Dimens
import com.example.nexus.ui.theme.FontSizes

@Composable
fun SeriesLazyRow(
    title: String,
    series: List<Serie>,
    onSerieClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                top = Dimens.Padding.extraLarge,
                start = Dimens.Padding.large
            )
    ) {
        Text(
            text = title,
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = FontSizes.bodyLarge,
            fontWeight = FontWeight.ExtraBold,
            maxLines = 1
        )

        Spacer(modifier = Modifier.height(Dimens.Padding.large))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(Dimens.Padding.medium)
        ) {
            items(series) { serie ->
                SerieCardSmall(
                    serie = serie,
                    onSerieClick = onSerieClick
                )
            }
        }
    }
}