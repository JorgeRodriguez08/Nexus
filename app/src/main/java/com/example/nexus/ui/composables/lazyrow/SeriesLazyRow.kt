package com.example.nexus.ui.composables.lazyrow

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.nexus.domain.model.Movie
import com.example.nexus.domain.model.Series
import com.example.nexus.ui.composables.card.MovieCardSmall
import com.example.nexus.ui.composables.card.SeriesCardSmall
import com.example.nexus.ui.navigation.NexusNavHost
import com.example.nexus.ui.theme.NexusTheme

@Composable
fun SeriesLazyRow(
    title: String,
    seriesList: List<Series>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(vertical = 8.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.SemiBold,
            maxLines = 2,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
        )

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(seriesList, key = {it.id}) { series ->
                SeriesCardSmall(series = series)
            }
        }
    }
}

@Preview (
    showBackground = true,
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)

@Composable
fun PreviewSeriesLazyRow() {
    NexusTheme{
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            NexusNavHost(rememberNavController())
        }
    }
}