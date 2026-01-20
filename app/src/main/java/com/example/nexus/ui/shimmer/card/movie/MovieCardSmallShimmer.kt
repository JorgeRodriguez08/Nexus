package com.example.nexus.ui.shimmer.card.movie

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.nexus.ui.shimmer.ShimmerDarkBox
import com.example.nexus.ui.theme.Dimens

@Composable
fun MovieCardSmallShimmer(
    modifier: Modifier = Modifier
) {
    ShimmerDarkBox(
        width = Dimens.Posters.small.width,
        height = Dimens.Posters.small.height,
        cornerRadius = Dimens.Radius.extraSmall
    )
}