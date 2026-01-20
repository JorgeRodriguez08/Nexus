package com.example.nexus.ui.shimmer.card.game

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.nexus.ui.shimmer.ShimmerDarkBox
import com.example.nexus.ui.theme.Dimens
import com.example.nexus.ui.theme.FontSizes

@Composable
fun GameMobileTopShimmer(
    index: Int,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.Top
    ) {
        Box(
            modifier = Modifier
                .width(Dimens.Box.small.width)
                .offset(x = Dimens.Padding.medium),
            contentAlignment = Alignment.BottomStart
        ) {
            Text(
                text = index.toString().substring(0,1),
                modifier = Modifier.padding(),
                style = TextStyle(
                    color = Color.White,
                    fontSize = FontSizes.displayLarge,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Default,
                    drawStyle = Stroke(width = 2f)
                ),
                maxLines = 1
            )
        }

        Column(
            modifier = modifier.width(Dimens.Posters.extraSmall.width),
            horizontalAlignment = Alignment.Start
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(Dimens.Posters.extraSmall.height),
                shape = RoundedCornerShape(Dimens.Radius.large),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.background
                ),
                border = BorderStroke(
                    width = Dimens.Borders.hairline,
                    color = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = Dimens.Alpha.regular)
                ),
            ) {
                ShimmerDarkBox(
                    width = Dimens.Posters.extraSmall.width,
                    height = Dimens.Posters.extraSmall.height,
                    cornerRadius = Dimens.Radius.large
                )
            }

            Spacer(modifier = Modifier.height(Dimens.Padding.small))

            ShimmerDarkBox(
                width = 100.dp,
                height = 20.dp,
                cornerRadius = 7.dp
            )

            Spacer(modifier = Modifier.height(3.dp))

            ShimmerDarkBox(
                width = 40.dp,
                height = 20.dp,
                cornerRadius = 7.dp
            )
        }
    }
}