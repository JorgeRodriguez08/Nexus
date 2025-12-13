package com.example.nexus.ui.screens.movieDetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.nexus.R
import com.example.nexus.domain.model.MovieDetails

@Composable
fun MovieDetailCard(
    movieDetail: MovieDetails,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1.7f),
            shape = RectangleShape
        ) {
            AsyncImage(
                model = movieDetail.movie.backdropUrl,
                contentDescription = movieDetail.movie.title,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                alignment = Alignment.TopCenter
            )
        }

        Text(
            text = movieDetail.movie.title,
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 33.sp,
            color = MaterialTheme.colorScheme.onSurface
        )


        Row(
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
        ) {
            Text(
                text = movieDetail.movie.releaseDate.substring(0, 4),
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontSize = 12.sp
            )
            Card(
                shape = RectangleShape,
                modifier = Modifier
                    .height(18.dp)
                    .wrapContentWidth()
            ) {
                Column(
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = if (movieDetail.movie.adult) "16+" else "16-",
                        color = MaterialTheme.colorScheme.onSecondaryContainer,
                        fontSize = 12.sp
                    )
                }
            }
            Text(
                text = "${movieDetail.movie.runtime / 60} h ${movieDetail.movie.runtime % 60} min",
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontSize = 12.sp
            )
        }

        Button(
            onClick = {
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.onSurface,
                contentColor = MaterialTheme.colorScheme.surface
            ),
            enabled = true,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(bottom = 2.dp),
            shape = RoundedCornerShape(2.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
            ) {
                Icon(
                    imageVector = Icons.Filled.PlayArrow,
                    contentDescription = "Ver",
                    modifier = Modifier.size(26.dp)
                )

                Spacer(modifier.size(6.dp))

                Text(
                    text = "Ver",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
            }
        }

        Button(
            onClick = {
            },
            enabled = false,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.onSurface,
                contentColor = MaterialTheme.colorScheme.surface
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(bottom = 2.dp),
            shape = RoundedCornerShape(2.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
            ) {
                Icon(
                    painter = painterResource(R.drawable.vertical_align_bottom),
                    contentDescription = "Descargar",
                    modifier = Modifier.size(26.dp),
                    tint = MaterialTheme.colorScheme.onSurface
                )

                Spacer(modifier.size(6.dp))

                Text(
                    text = "Descargar",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = movieDetail.movie.overview,
            fontSize = 13.sp,
            color = MaterialTheme.colorScheme.onSurface,
            lineHeight = 16.sp,
            maxLines = 4
        )

        Text(
            text = "Protagonistas: " + movieDetail.cast.joinToString(", ") { it.name },
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = 11.5.sp,
            lineHeight = 16.sp,
            maxLines = 2
        )

        val director = movieDetail.crew.find { it.job == "Director" }?.name ?: "Desconocido"

        Text(
            text = "Dirección: " + director,
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = 11.5.sp
        )

    }
}