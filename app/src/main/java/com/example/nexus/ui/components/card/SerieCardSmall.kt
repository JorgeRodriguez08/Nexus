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
import com.example.nexus.domain.model.Serie
import com.example.nexus.ui.theme.Dimens

@Composable
fun SerieCardSmall(
    serie: Serie,
    modifier: Modifier = Modifier,
    onSerieClick: (Int) -> Unit
) {
    val posterSmall = Dimens.Posters.medium
    Card(
        modifier = modifier
            .width(posterSmall.width)
            .height(posterSmall.height)
            .clickable(onClick = { onSerieClick(serie.id) }),
        shape = RoundedCornerShape(Dimens.Radius.extraSmall)
    ) {
        AsyncImage(
            model = serie.posterUrl,
            contentDescription = serie.title,
            contentScale = ContentScale.Crop
        )
    }
}