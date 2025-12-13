package com.example.nexus.ui.screens.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.nexus.R
import com.example.nexus.domain.model.Movie

@Composable
fun MoviesAndSeriesSection(
    movies: List<Movie>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Serie y películas recomendadas",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 18.sp,
            color = MaterialTheme.colorScheme.onSurface
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            movies.forEach { movie ->
                MovieAndSerieRecommended(
                    movie = movie,
                    modifier = Modifier.fillMaxWidth()
                )
            }

        }
    }
}


@Composable
fun MovieAndSerieRecommended(
    movie: Movie,
    modifier: Modifier
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically

    ) {
        AsyncImage(
            model = movie.backdropUrl,
            contentDescription = "Power Card Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(width = 136.dp, height = 76.dp)
                .clip(RoundedCornerShape(3.dp))
        )

        Text(
            text = movie.title,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 2,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier
                .weight(1f)
                .padding(start = 10.dp)
        )

        Icon(
            painter = painterResource(R.drawable.play_circle_60dp),
            contentDescription = "Play Icon",
            modifier = Modifier
                .size(49.dp)
                .padding(end = 8.dp),
            tint = MaterialTheme.colorScheme.onSurface
        )
    }
}

