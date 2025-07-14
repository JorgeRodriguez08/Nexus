package com.example.nexus.ui.composables.card

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.nexus.R
import com.example.nexus.domain.model.Series
import com.example.nexus.ui.samples.Samples
import com.example.nexus.ui.theme.NexusTheme

@Composable
fun SeriesCardSmall(
    series: Series,
    modifier: Modifier = Modifier,
    width: Dp = 120.dp,
    height: Dp = 180.dp
) {
    Card(
        modifier = modifier
            .width(width)
            .height(height)
    ) {
        AsyncImage(
            model = series.posterUrl,
            contentDescription = series.title,
            contentScale = ContentScale.Crop,
            placeholder = painterResource(R.drawable.squid_game),
            error = painterResource(R.drawable.squid_game)
        )
    }
}

@Preview (
    showBackground = true,
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun PreviewSeriesCardSmall() {
    NexusTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                SeriesCardSmall(
                    series = Samples.series,
                )
            }
        }
    }
}
