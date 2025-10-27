package com.example.nexus.ui.screens.newsPopular.preview

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nexus.R

@Composable
fun NewsPopularLayoutFake(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
        ,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        item {
            LazyRow(
                modifier = Modifier.padding(horizontal = 2.dp),
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

        item {
            Card(
                modifier = Modifier
                    .width(388.dp)
                    .height(500.dp),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.background
                ),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.30f))
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box {
                        Image(
                            painter = painterResource(R.drawable.tron_backdrops),
                            contentDescription = "Poster Image",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(214.dp)
                                .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp)),
                        )

                        Card(
                            shape = RectangleShape,
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .padding(top = 8.dp, end = 8.dp)
                                .width(40.dp)
                                .height(23.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = MaterialTheme.colorScheme.background
                            )
                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "16+",
                                    color = MaterialTheme.colorScheme.onSurface,
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 13.sp
                                )
                            }
                        }
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 12.dp, vertical = 6.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(R.drawable.tron_logos),
                            contentDescription = "Poster Image",
                            modifier = Modifier.height(55.dp)
                        )
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp, vertical = 5.dp),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = "Estreno el jueves",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )

                        Text(
                            text = "Un elixir reanima a los muertos en una aldea. Una familia en conflicto debe unirse y luchar por sobrevivir mientras su hogar colapsa.",
                            fontSize = 12.75.sp,
                            lineHeight = 16.sp,
                            fontWeight = FontWeight.Normal,
                            color = MaterialTheme.colorScheme.onSurface
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Button(
                            onClick = {},
                            modifier = Modifier
                                .width(150.dp)
                                .height(47.dp),
                            shape = RoundedCornerShape(4.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.onSurface,
                                contentColor = MaterialTheme.colorScheme.surface

                            ),
                            contentPadding = PaddingValues(horizontal = 4.dp, vertical = 4.dp)

                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Outlined.Notifications,
                                    contentDescription = "Notification Icon",
                                    modifier = Modifier.size(25.dp)
                                )

                                Spacer(Modifier.width(6.dp))

                                Text(
                                    text = "Avisarme",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    maxLines = 1
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}