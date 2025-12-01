package com.example.nexus.ui.components.card

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.nexus.domain.model.Series

@Composable
fun SeriesCardSmall(
    series: Series,
    modifier: Modifier = Modifier,
    onSeriesClick: (Int) -> Unit
) {
    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = modifier
            .width(116.dp)
            .height(162.dp)
            .clickable(onClick = { onSeriesClick })
    ) {
        AsyncImage(
            model = series.posterUrl,
            contentDescription = series.title,
            contentScale = ContentScale.Crop
        )
    }
}