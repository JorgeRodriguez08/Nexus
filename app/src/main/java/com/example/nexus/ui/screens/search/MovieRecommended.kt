package com.example.nexus.ui.screens.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import coil.compose.AsyncImage
import com.example.nexus.R
import com.example.nexus.domain.model.Movie
import com.example.nexus.ui.theme.Dimens
import com.example.nexus.ui.theme.FontSizes
import com.example.nexus.ui.theme.Strings

@Composable
fun MovieRecommended(
    movie: Movie,
    onMovieClick: (Int) -> Unit,
    modifier: Modifier
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = { onMovieClick(movie.id) })
        ,
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = movie.backdropUrl,
            contentDescription = movie.title,
            modifier = Modifier
                .size(width = Dimens.Posters.base.width, height = Dimens.Posters.base.height)
                .clip(RoundedCornerShape(Dimens.Radius.extraExtraSmall)),
            contentScale = ContentScale.Crop,
        )

        Text(
            text = movie.title,
            modifier = Modifier
                .weight(1f)
                .padding(start = Dimens.Padding.base),
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = FontSizes.bodyMedium,
            fontWeight = FontWeight.Bold,
            maxLines = 2
        )

        Icon(
            painter = painterResource(R.drawable.play_circle_60dp),
            contentDescription = Strings.Icons.playIcon,
            modifier = Modifier
                .size(Dimens.Icons.extraExtraLarge)
                .padding(end = Dimens.Padding.medium),
            tint = MaterialTheme.colorScheme.onSurface
        )
    }
}