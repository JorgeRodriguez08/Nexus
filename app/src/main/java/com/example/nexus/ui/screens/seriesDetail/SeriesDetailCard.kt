package com.example.nexus.ui.screens.seriesDetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.nexus.domain.model.SerieDetails

@Composable
fun SeriesDetailCard(
    serieDetails: SerieDetails,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = modifier
                .width(340.dp)
                .height(500.dp)
        ) {
            AsyncImage(
                model = serieDetails.serie.posterUrl,
                contentDescription = serieDetails.serie.title,
                contentScale = ContentScale.Crop,
                modifier = modifier.fillMaxSize(),
                alignment = Alignment.Center
            )
        }

        Row {
            Text(text = serieDetails.serie.title)
            Text(text = serieDetails.serie.overview)
            Text(text = serieDetails.serie.id.toString())
        }
    }
}