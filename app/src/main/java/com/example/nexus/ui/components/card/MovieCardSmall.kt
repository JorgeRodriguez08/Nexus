package com.example.nexus.ui.components.card

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.nexus.R
import com.example.nexus.domain.model.Movie

@Composable
fun MovieCardSmall(
    movie: Movie,
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
            model = movie.posterUrl,
            contentDescription = movie.title,
            contentScale = ContentScale.Crop
        )
    }
}


