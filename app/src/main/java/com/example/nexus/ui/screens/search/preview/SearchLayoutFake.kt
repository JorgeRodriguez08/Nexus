package com.example.nexus.ui.screens.search.preview

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 13.dp, top = 10.dp),
        verticalArrangement = Arrangement.spacedBy(13.dp),
        horizontalAlignment = Alignment.Start

    ) {
        item {
            GameSectionFake()
        }

        item {
            MovieAndSerieSectionFake()
        }

    }
}


@Composable
fun MovieAndSerieSectionFake(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Series y películas recomendadas",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 18.sp,
            color = MaterialTheme.colorScheme.onSurface
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            searchList.forEach { searchItem ->
                MovieAndSerieRecommendedFake(
                    imageRes = searchItem.imageRes,
                    title = searchItem.title,
                    modifier = Modifier.fillMaxWidth()
                )
            }

        }
    }
}


@Composable
fun GameSectionFake(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 3.dp)
    ) {
        Text(
            text = "Juegos móviles recomendados",
            fontSize = 18.sp,
            fontWeight = FontWeight.ExtraBold,
            color = MaterialTheme.colorScheme.onSurface
        )

        Spacer(modifier = Modifier.height(4.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(9.dp)
        ) {
            items(gameList) { gameItem ->
                GameRecommendedFake(
                    imageRes = gameItem.imageRes,
                    title = gameItem.title,
                    genre = gameItem.genre
                )
            }
        }
    }
}


@Composable
fun GameRecommendedFake(
    imageRes: Int,
    title: String,
    genre: String,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = modifier.width(113.dp)
    ) {
        Card(
            shape = RoundedCornerShape(13.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.background
            ),
            border = BorderStroke(
                width = 1.dp,
                color = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.3f)),
            modifier = Modifier
                .height(113.dp)
                .fillMaxWidth(),
        ) {
            Image(
                painter = painterResource(imageRes),
                contentDescription = "Game Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

        }

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = title,
            fontSize = 11.sp,
            fontWeight = FontWeight.ExtraBold,
            maxLines = 2,
            lineHeight = 14.sp,
            color = MaterialTheme.colorScheme.onSurface
        )

        Text(
            text = genre,
            fontSize = 11.sp,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}


@Composable
fun MovieAndSerieRecommendedFake(
    imageRes: Int,
    title: String,
    modifier: Modifier
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically

    ) {
        Image(
            painter = painterResource(imageRes),
            contentDescription = "Power Card Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(width = 136.dp, height = 76.dp)
                .clip(RoundedCornerShape(3.dp))
        )

        Text(
            text = title,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 2,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier
                .weight(1f)
                .padding(start = 10.dp)
        )

        Icon(
            painter = painterResource(R.drawable.play_circle_60dp),
            contentDescription = "Play Icon",
            modifier = Modifier
                .size(49.dp)
                .padding(end = 8.dp),
            tint = MaterialTheme.colorScheme.onSurface
        )
    }
}

data class GameItem(
    val imageRes: Int,
    val title: String,
    val genre: String
)

val gameList: List <GameItem> = listOf(
    GameItem(R.drawable.liloystich, "Football Manager \n26 Mobile", "Deportes"),
    GameItem(R.drawable.sonic, "Toca Boca Hair \nSalon 4", "Infantil"),
    GameItem(R.drawable.avengers, "Blood Line: Un \njuego de Reb...", "Acción"),
    GameItem(R.drawable.squid_game, "El juego del \ncalamar", "Acción"),
    GameItem(R.drawable.liloystich, "Football \nManager 26...", "Deportes"),
    GameItem(R.drawable.sonic, "Toca Boca Hair \nSalon 4", "Infantil"),
    GameItem(R.drawable.avengers, "Blood Line: Un \njuego de Reb...", "Acción"),
    GameItem(R.drawable.squid_game, "El juego del \ncalamar", "Acción"),
)


data class SearchItem(
    val imageRes: Int,
    val title: String
)

val searchList: List<SearchItem> = listOf(
    SearchItem(R.drawable.el_ninja_de_berverly_hills, "Un ninja en Beverly Hills"),
    SearchItem(R.drawable.the_walking_dead, "The Walking Dead"),
    SearchItem(R.drawable.squid_game_2, "El juego del calamar"),
    SearchItem(R.drawable.spartacus, "Spartacus"),
    SearchItem(R.drawable.the_elixir, "El elixir de la inmortalidad"),
    SearchItem(R.drawable.sonic, "Sonic: La Película"),
    SearchItem(R.drawable.avengers, "Avengers: Endgame"),
    SearchItem(R.drawable.tron_backdrops, "Tron: Legacy"),
)