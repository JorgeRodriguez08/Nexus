package com.example.nexus.ui.components.card.serie

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.SubcomposeAsyncImage
import com.example.nexus.domain.model.Serie
import com.example.nexus.ui.shimmer.ShimmerDarkBox
import com.example.nexus.ui.theme.Dimens

@Composable
fun SerieCardSmall(
    serie: Serie,
    onSerieClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .width(Dimens.Posters.small.width)
            .height(Dimens.Posters.small.height)
            .clickable(onClick = { onSerieClick(serie.id) }),
        shape = RoundedCornerShape(Dimens.Radius.extraSmall)
    ) {
        SubcomposeAsyncImage(
            model = serie.posterUrl,
            contentDescription = serie.title,
            contentScale = ContentScale.Crop,
            loading = {
                ShimmerDarkBox(
                    width = Dimens.Posters.small.width,
                    height = Dimens.Posters.small.height,
                    cornerRadius = Dimens.Radius.extraSmall
                )
            }
        )
    }
}