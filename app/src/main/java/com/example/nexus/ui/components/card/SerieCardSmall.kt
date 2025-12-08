package com.example.nexus.ui.components.card

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import com.example.nexus.domain.models.Serie
import com.example.nexus.ui.theme.Dimens

@Composable
fun SerieCardSmall(
    serie: Serie,
    onSerieClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val posterSmall = Dimens.Poster.small
    Card(
        shape = RoundedCornerShape(Dimens.Radius.small),
        modifier = modifier
            .width(posterSmall.width)
            .height(posterSmall.height)
            .clickable(onClick = { onSerieClick })
    ) {
        AsyncImage(
            model = serie.posterUrl,
            contentDescription = serie.title,
            contentScale = ContentScale.Crop
        )
    }
}