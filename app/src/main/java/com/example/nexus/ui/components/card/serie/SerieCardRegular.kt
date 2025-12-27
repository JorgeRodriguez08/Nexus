package com.example.nexus.ui.components.card.serie

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
fun SerieCardRegular(
    serie: Serie,
    modifier: Modifier = Modifier,
    onSerieClick: (Int) -> Unit
) {
    Card(
        modifier = modifier
            .width(Dimens.Posters.regular.width)
            .height(Dimens.Posters.regular.height)
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