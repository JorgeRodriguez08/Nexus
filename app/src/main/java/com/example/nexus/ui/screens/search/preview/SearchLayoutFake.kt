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
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.text.style.TextAlign
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
        verticalArrangement = Arrangement.spacedBy(14.dp),
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
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(9.dp),
                modifier = Modifier.padding(horizontal = 4.dp, vertical = 10.dp)
            ) {
                items(gameList) { gameItem ->
                    GameRecommended(
                        imageRes = gameItem.imageRes,
                        title = gameItem.title,
                        genre = gameItem.genre,
                        modifier = Modifier
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

        items(searchList) { searchItem ->
            SectionRecommended(
                title = searchItem.title,
                imageRes = searchItem.imageRes,
                modifier = Modifier.fillMaxWidth()
            )
        }


    }
}

@Composable
fun GameRecommended(
    imageRes: Int,
    title: String,
    genre: String,
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
                painter = painterResource(imageRes),
                contentDescription = "Game Image",
                contentScale = ContentScale.Crop
            )

        }
        Text(
            text = title,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 2,
            lineHeight = 18.sp,
            color = MaterialTheme.colorScheme.onSurface
        )

        Text(
            text = genre,
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}


@Composable
fun SectionRecommended(
    imageRes: Int,
    title: String,
    modifier: Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(imageRes),
                contentDescription = "Power Card Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(width = 140.dp, height = 80.dp)
                    .clip(RectangleShape)
            )

            Text(
                text = title,
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Justify,
                maxLines = 2,
            )
        }

        Icon(
            imageVector = Icons.Outlined.PlayArrow,
            contentDescription = "Play Icon"
        )
    }
}

data class GameItem(
    val imageRes: Int,
    val title: String,
    val genre: String
)

val gameList: List <GameItem> = listOf(
    GameItem(R.drawable.liloystich, "Football Manager 26...", "Deportes"),
    GameItem(R.drawable.sonic, "Toca Boca Hair Salon 4", "Infantil"),
    GameItem(R.drawable.avengers, "Blood Line: Un juego de Reb...", "Acción"),
    GameItem(R.drawable.squid_game, "El juego del calamar", "Acción"),
    GameItem(R.drawable.liloystich, "Football Manager 26...", "Deportes"),
    GameItem(R.drawable.sonic, "Toca Boca Hair Salon 4", "Infantil"),
    GameItem(R.drawable.avengers, "Blood Line: Un juego de Reb...", "Acción"),
    GameItem(R.drawable.squid_game, "El juego del calamar", "Acción"),
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