package com.example.nexus.ui.components.topappbar

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nexus.R
import com.example.nexus.ui.components.filterrowbar.FilterRowBar
import com.example.nexus.ui.navigation.Destinations

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NexusTopAppBar(
    modifier: Modifier = Modifier,
    currentRoute: String,
    canNavigateBack: Boolean,
    onSearchClick: () -> Unit,
    onBackClick: () -> Unit,
    onDownloadClick: () -> Unit,
    onFilterSelected: (String) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        TopAppBar(
            title = { Text(text = getTitleForRoute(currentRoute)) },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.background,
                titleContentColor = MaterialTheme.colorScheme.onBackground
            ),
            navigationIcon = {
                if (canNavigateBack) {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.back_icon)
                        )
                    }
                } else {
                    Image(
                        painter = painterResource(R.drawable.icons8_netflix_96),
                        contentDescription = stringResource(R.string.nexus_icon),
                        modifier = Modifier.size(43.dp)
                    )
                }
            },
            actions = {
                TopBarAction(
                    iconRes = R.drawable.cast_24dp,
                    contentDescription = stringResource(R.string.home_screen),
                    onClick = { }
                )
                TopBarAction(
                    iconRes = R.drawable.vertical_align_bottom,
                    contentDescription = stringResource(R.string.home_screen),
                    onClick = onDownloadClick
                )
                TopBarAction(
                    iconRes = R.drawable.magnifying_glass,
                    contentDescription = stringResource(R.string.search_icon),
                    onClick = onSearchClick
                )
            },
            modifier = modifier
        )

        FilterRowBar(
            selectedOption = currentRoute,
            onOptionSelected = onFilterSelected

        )
    }
}

@Composable
fun TopBarAction(
    @DrawableRes iconRes: Int,
    contentDescription: String,
    onClick: () -> Unit
) {
    IconButton(onClick = onClick) {
        Icon(
            painter = painterResource(iconRes),
            contentDescription = contentDescription,
            modifier = Modifier.size(28.dp)
        )
    }
}

fun getTitleForRoute(route: String): String {
    return when (route) {
        Destinations.Home.route -> Destinations.Home.route
        Destinations.Movies.route -> Destinations.Movies.route
        Destinations.Series.route -> Destinations.Series.route
        Destinations.Categories.route -> Destinations.Categories.route
        Destinations.Games.route -> Destinations.Games.route
        Destinations.NewsAndPopular.route -> Destinations.NewsAndPopular.route
        Destinations.MyNexus.route -> Destinations.MyNexus.route
        Destinations.Search.route -> Destinations.Search.route
        Destinations.MovieDetail.route -> Destinations.MovieDetail.route
        Destinations.SeriesDetail.route -> Destinations.SeriesDetail.route
        else -> ""
    }
}


