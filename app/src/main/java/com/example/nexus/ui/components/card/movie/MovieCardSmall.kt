package com.example.nexus.ui.components.card.movie

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import com.example.nexus.domain.model.Movie
import com.example.nexus.ui.theme.Dimens

@Composable
fun MovieCardSmall(
    movie: Movie,
    onMovieClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .width(Dimens.Posters.small.width)
            .height(Dimens.Posters.small.height)
            .clickable(onClick = { onMovieClick(movie.id) }),
        shape = RoundedCornerShape(Dimens.Radius.extraSmall)
    ) {
        AsyncImage(
            model = movie.posterUrl,
            contentDescription = movie.title,
            contentScale = ContentScale.Crop
        )
    }
}