package com.example.nexus.ui.screens.newsPopular

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nexus.ui.navigation.Destinations.Companion.newsFilter

@Composable
fun NewsFilterBar(
    modifier: Modifier = Modifier
) {

    val options = newsFilter

    LazyRow(
        modifier = modifier.padding(start = 12.dp, end = 12.dp, top = 1.dp, bottom = 14.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)) {

        item {
            FilterChip(
                selected = false,
                onClick = { },
                label = { Text("\uD83C\uDF7F Próximamente", fontSize = 14.sp) },
                modifier = Modifier.height(40.dp),
                shape = RoundedCornerShape(18.dp)
            )
        }

        item {
            FilterChip(
                selected = false,
                onClick = { },
                label = { Text("\uD83D\uDD25 Lo más cool", fontSize = 14.sp) },
                modifier = Modifier.height(40.dp),
                shape = RoundedCornerShape(18.dp)
            )
        }

        item {
            FilterChip(
                selected = false,
                onClick = { },
                label = { Text("\uD83C\uDFAE Juegos móviles", fontSize = 14.sp) },
                modifier = Modifier.height(40.dp),
                shape = RoundedCornerShape(18.dp)
            )
        }

        item {
            FilterChip(
                selected = false,
                onClick = { },
                label = { Text("Las 10 series más populares", fontSize = 14.sp) },
                modifier = Modifier.height(40.dp),
                shape = RoundedCornerShape(18.dp)
            )
        }

        item {
            FilterChip(
                selected = false,
                onClick = {},
                label = { Text("Las 10 películas más populares", fontSize = 14.sp) } ,
                modifier = Modifier.height(40.dp),
                shape = RoundedCornerShape(18.dp)
            )
        }
    }
}