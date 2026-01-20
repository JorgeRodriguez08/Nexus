package com.example.nexus.ui.shimmer.card.serie

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.nexus.ui.shimmer.ShimmerDarkBox
import com.example.nexus.ui.theme.Dimens

@Composable
fun SerieCardSmallShimmer(
    modifier: Modifier = Modifier
) {
    ShimmerDarkBox(
        width = Dimens.Posters.small.width,
        height = Dimens.Posters.small.height,
        cornerRadius = Dimens.Radius.extraSmall
    )
}