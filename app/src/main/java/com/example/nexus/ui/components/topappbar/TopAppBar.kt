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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.nexus.R
import com.example.nexus.ui.components.filterbar.FilterBar
import com.example.nexus.ui.navigation.Destinations
import com.example.nexus.ui.navigation.Destinations.Companion.findDestination
import com.example.nexus.ui.screens.newsPopular.FilterType
import com.example.nexus.ui.screens.newsPopular.NewsFilterBar
import com.example.nexus.ui.theme.Dimens
import com.example.nexus.ui.theme.FontSize

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NexusTopAppBar(
    currentRoute: String,
    canNavigateBack: Boolean,
    onBackClick: () -> Unit,
    onFilterSelected: (String) -> Unit,
    selectedFilter: FilterType,
    onSearchClick: () -> Unit,
    onDownloadClick: () -> Unit,
    onNewFilterSelected: (FilterType) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        TopAppBar(
            title = {
                Text(
                    text =
                        when (findDestination(currentRoute)) {
                            Destinations.MovieDetail -> ""
                            Destinations.SerieDetail -> ""
                            else -> currentRoute
                    },
                    color = MaterialTheme.colorScheme.onSurface,
                    fontSize = FontSize.large,
                    fontWeight = FontWeight.Bold
                )
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Transparent,
                titleContentColor = MaterialTheme.colorScheme.onSurface
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
                        painter = painterResource(R.drawable.netflix_icon),
                        contentDescription = stringResource(R.string.app_icon),
                        modifier = Modifier.size(Dimens.IconSize.large)
                    )
                }
            },
            actions = {
                TopBarAction(
                    iconRes = R.drawable.cast_icon,
                    contentDescription = stringResource(R.string.cast_icon),
                    onClick = { }
                )
                TopBarAction(
                    iconRes = R.drawable.download_icon,
                    contentDescription = stringResource(R.string.download_icon),
                    onClick = onDownloadClick
                )
                TopBarAction(
                    iconRes = R.drawable.search_icon,
                    contentDescription = stringResource(R.string.search_icon),
                    onClick = onSearchClick
                )
            },
            modifier = modifier
        )

        if (Destinations.shouldShowFilterBar(currentRoute)) {
            FilterBar(
                selectedOption = currentRoute,
                onOptionSelected = onFilterSelected
            )
        }

        if (Destinations.shouldShowNewsFilterBar(currentRoute)) {
            NewsFilterBar(
                selectedFilter = selectedFilter,
                onNewFilterSelected = onNewFilterSelected
            )
        }
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
            modifier = Modifier.size(Dimens.IconSize.small)
        )
    }
}
