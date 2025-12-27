package com.example.nexus.ui.components.card.serie

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import coil.compose.AsyncImage
import com.example.nexus.domain.model.Serie
import com.example.nexus.ui.theme.Dimens
import com.example.nexus.ui.theme.FontSizes

@Composable
fun SerieTop(
    serie: Serie,
    index: Int,
    onSerieClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.Bottom
    ) {
        Box(
            modifier = Modifier
                .width(Dimens.Box.small.width)
                .offset(x = Dimens.Padding.micro),
            contentAlignment = Alignment.BottomStart
        ) {
            Text(
                text = index.toString().substring(0,1),
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .offset(y = Dimens.Padding.sectionSmall),
                style = TextStyle(
                    color = Color.White,
                    fontSize = FontSizes.displayHuge,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = FontFamily.Default,
                    drawStyle = Stroke(width = 2f)
                ),
                maxLines = 1
            )
        }

        Card(
            modifier = modifier
                .width(Dimens.Posters.top.width)
                .height(Dimens.Posters.top.height)
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
}