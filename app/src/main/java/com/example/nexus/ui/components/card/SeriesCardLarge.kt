package com.example.nexus.ui.components.card

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.nexus.domain.model.Serie

@Composable
fun SeriesCardLarge(
    serie: Serie,
    modifier: Modifier = Modifier,
    onSeriesClick: (Int) -> Unit
) {
    Card(
        modifier = modifier
            .width(340.dp)
            .height(500.dp)
            .clickable(onClick = { onSeriesClick(serie.id) })
    ) {
        AsyncImage(
            model = serie.posterUrl,
            contentDescription = serie.title,
            contentScale = ContentScale.Crop,
            modifier = modifier.fillMaxSize(),
            alignment = Alignment.Center,
        )
    }
}
