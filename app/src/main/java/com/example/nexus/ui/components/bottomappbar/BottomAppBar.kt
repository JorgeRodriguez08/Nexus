package com.example.nexus.ui.components.bottomappbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nexus.R
import com.example.nexus.ui.navigation.Destinations

@Composable
fun NexusBottomAppBar(
    modifier: Modifier = Modifier,
    currentRoute: String,
    onNavigate: (String) -> Unit
) {
    if (Destinations.shouldShowBottomBar(currentRoute)) {
        NavigationBar(
            modifier = modifier.height(110.dp)
        ) {
            val items = listOf(
                Triple(Destinations.Home.route, R.drawable.outlined_home, R.drawable.filled_home),
                Triple(Destinations.Games.route, R.drawable.outlined_game, R.drawable.filled_game),
                Triple(Destinations.NewsAndPopular.route, R.drawable.outlined_play, R.drawable.filled_play),
                Triple(Destinations.MyNexus.route, R.drawable.outlined_profile, R.drawable.filled_profile)
            )

            items.forEachIndexed { index, (destination, outlinedIcon, filledIcon) ->
                NavigationBarItem(
                    selected = currentRoute == destination,
                    onClick = { onNavigate(destination) },
                    icon = {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                painter = painterResource(if (currentRoute == destination) filledIcon else outlinedIcon),
                                modifier = Modifier.size(27.dp),
                                contentDescription = destination,
                                tint = if (currentRoute == destination) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.onSecondaryContainer
                            )

                            Text(
                                text = destination,
                                style = MaterialTheme.typography.labelSmall,
                                fontSize = 7.sp,
                                color = if (currentRoute == destination) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.onSecondaryContainer
                            )
                        }
                    },
                    label = {},
                    alwaysShowLabel = false
                )
            }
        }
    }
}
