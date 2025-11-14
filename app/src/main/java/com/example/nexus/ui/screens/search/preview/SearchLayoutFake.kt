package com.example.nexus.ui.screens.search.preview

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nexus.R

@Composable
fun SearchLayoutFake(
    modifier: Modifier = Modifier
) {
    var searchText by remember() { mutableStateOf("") }
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 3.dp, end = 3.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.Start

    ) {
        item {

            OutlinedTextField(
                value = searchText,
                onValueChange = { newText -> searchText = newText },
                placeholder = {
                    Text(
                        text = "Buscar series, películas y juegos",
                        fontSize = 20.sp
                    )
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.magnifying_glass),
                        contentDescription = stringResource(R.string.search_icon),
                        modifier = Modifier.size(26.dp)
                    )
                },
                singleLine = true,
                modifier = Modifier
                    .padding(1.dp)
                    .fillMaxWidth()
                    .height(52.dp)
            )
        }

        item {
            
            Text(
                text = "Juegos móviles recomendados",
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
                color = MaterialTheme.colorScheme.onSurface
            )

            LazyRow(
                modifier = Modifier.padding(horizontal = 4.dp, vertical = 10.dp),
                horizontalArrangement = Arrangement.spacedBy(9.dp)
            ) {
                item {
                    GameCard(
                        title = "Football \nManager 26...",
                        genre = "Deportes",
                        image = R.drawable.liloystich,
                        modifier = modifier
                    )
                }

                item {
                    GameCard(
                        title = "Toca Boca Hair Salon 4",
                        genre = "Infantil",
                        image = R.drawable.sonic,
                        modifier = modifier
                    )
                }

                item {
                    GameCard(
                        title = "Blood Line: Un \njuego de Reb...",
                        genre = "Acción",
                        image = R.drawable.avengers,
                        modifier = modifier
                    )
                }

                item {
                    GameCard(
                        title = "El juego del \ncalamar",
                        genre = "Acción",
                        image = R.drawable.squid_game,
                        modifier = modifier
                    )
                }

                item {
                    GameCard(
                        title = "Football \nManager 26...",
                        genre = "Deportes",
                        image = R.drawable.liloystich,
                        modifier = modifier
                    )
                }

                item {
                    GameCard(
                        title = "Toca Boca Hair Salon 4",
                        genre = "Infantil",
                        image = R.drawable.sonic,
                        modifier = modifier
                    )
                }

                item {
                    GameCard(
                        title = "Blood Line: Un \njuego de Reb...",
                        genre = "Acción",
                        image = R.drawable.avengers,
                        modifier = modifier
                    )
                }

                item {
                    GameCard(
                        title = "El juego del \ncalamar",
                        genre = "Acción",
                        image = R.drawable.squid_game,
                        modifier = modifier
                    )
                }


            }
        }

        item {
            Text(
                text = "Series y películas recomendadas",
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
                color = MaterialTheme.colorScheme.onSurface
            )
        }

        /*item {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                item {
                    PowerCard(
                        modifier = modifier,
                        title = "Un ninja en Beverly Hills",
                        image = R.drawable.tron_backdrops
                    )
                }
            }
        }*/
    }
}

@Composable
fun GameCard(
    title: String,
    genre: String,
    image: Int,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(3.dp),
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .width(110.dp)
    ) {
        Card(
            modifier = Modifier
                .height(110.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.background
            ),
            border = BorderStroke(1.5.dp, MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.30f))
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = "Game Image",
                contentScale = ContentScale.Crop
            )

        }
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            maxLines = 2,
            lineHeight = 18.sp,
            fontSize = 15.sp,
            color = MaterialTheme.colorScheme.onSurface
        )

        Text(
            text = genre,
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

/*
@Composable
fun PowerCard(
    title: String,
    image: Int,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = "Power Card Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(width = 130.dp, height = 80.dp)
                .clip(RectangleShape)
        )

        Text(
            text = title
        )

        Icon(
            imageVector = Icons.Outlined.PlayArrow,
            contentDescription = "Play Icon"
        )
    }

}*/