package com.example.nexus.ui.components.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.nexus.domain.model.Movie

@Composable
fun MovieCardLarge(
    movie: Movie,
    modifier: Modifier = Modifier,
    onMovieClick: (Int) -> Unit
) {
    Card(
        modifier = modifier
            .width(360.dp)
            .height(495.dp)
            .clickable(onClick = { onMovieClick(movie.id) }),
        border =  BorderStroke(1.dp, MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.50f)),
        elevation = CardDefaults.cardElevation(15.dp),
        shape = RoundedCornerShape(11.dp)
    ) {
        Box {
            AsyncImage(
                model = movie.posterUrl,
                contentDescription = movie.title,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.surfaceContainerHigh),
                alignment = Alignment.Center
            )

            Row(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 13.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)

            ) {

                ButtonOfCardLarge(
                    text = "Reproducir",
                    imageVector = Icons.Filled.PlayArrow,
                    enabled = true,
                    onClick = {  },
                    color = MaterialTheme.colorScheme.surface,
                    modifier = Modifier
                )

                ButtonOfCardLarge(
                    text = "Mi lista",
                    imageVector = Icons.Filled.Add,
                    enabled = false,
                    onClick = {  },
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier
                )
            }
        }
    }
}


@Composable
fun ButtonOfCardLarge(
    text: String,
    imageVector: ImageVector,
    enabled: Boolean,
    color: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.onSurface,
            contentColor = MaterialTheme.colorScheme.surface,
            disabledContentColor = MaterialTheme.colorScheme.onSurface,
            disabledContainerColor = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.45f)
        ),
        modifier = Modifier
            .width(157.dp)
            .height(38.dp),
        shape = RoundedCornerShape(4.dp),
        contentPadding = PaddingValues(horizontal = 1.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = imageVector,
                contentDescription = text,
                modifier = Modifier.size(33.dp),
                tint = color
            )

            Text(
                text = text,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = color
            )
        }
    }

}