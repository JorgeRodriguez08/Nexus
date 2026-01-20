package com.example.nexus.ui.shimmer.card.serie

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.nexus.ui.shimmer.ShimmerDarkBox
import com.example.nexus.ui.theme.Dimens

@Composable
fun SerieCardRegularShimmer(
    modifier: Modifier = Modifier
) {
    ShimmerDarkBox(
        width = Dimens.Posters.regular.width,
        height = Dimens.Posters.regular.height,
        cornerRadius = Dimens.Radius.extraSmall
    )
}