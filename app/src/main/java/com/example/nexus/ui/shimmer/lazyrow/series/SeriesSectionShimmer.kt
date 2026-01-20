package com.example.nexus.ui.shimmer.lazyrow.series

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.nexus.ui.shimmer.card.serie.SerieRecommendedShimmer
import com.example.nexus.ui.theme.Dimens

@Composable
fun SeriesSectionShimmer(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(Dimens.Padding.medium)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(Dimens.Padding.medium)
        ) {
            List(20) { it + 1 }.forEach { it ->
                SerieRecommendedShimmer(
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}