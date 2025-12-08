package com.example.nexus.ui.components.lazyrow

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
import com.example.nexus.domain.models.Serie
import com.example.nexus.ui.components.card.SerieCardSmall
import com.example.nexus.ui.theme.Dimens
import com.example.nexus.ui.theme.FontSize

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
            .padding(top = Dimens.Padding.extraSmall)
    ) {
        Text(
            text = title,
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = FontSize.regular,
            fontWeight = FontWeight.ExtraBold,
            maxLines = 1
        )

        Spacer(modifier = Modifier.height(Dimens.Spacing.extraSmall))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(Dimens.Spacing.medium)
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