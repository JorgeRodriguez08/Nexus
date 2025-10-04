package com.example.nexus.ui.components.bottomappbar

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import com.example.nexus.R
import com.example.nexus.ui.navigation.Destinations

@Composable
fun NexusBottomAppBar(
    modifier: Modifier = Modifier,
    currentRoute: String,
    onNavigate: (String) -> Unit
) {
    NavigationBar(
        modifier = modifier
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
                    Icon(
                        painter = painterResource(if (currentRoute == destination) filledIcon else outlinedIcon),
                        contentDescription = destination
                    )
                },
                label = {
                    Text(
                        text = destination,
                        style = MaterialTheme.typography.labelSmall,
                        fontSize = 10.sp
                    )
                }
            )
        }
    }
}