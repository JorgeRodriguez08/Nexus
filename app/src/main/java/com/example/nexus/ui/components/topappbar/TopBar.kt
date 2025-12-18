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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.example.nexus.R
import com.example.nexus.ui.components.filterbar.FilterBar
import com.example.nexus.ui.navigation.Destinations
import com.example.nexus.ui.navigation.Destinations.Companion.findDestination
import com.example.nexus.ui.components.filterbar.NewFilterType
import com.example.nexus.ui.components.filterbar.NewsFilterBar
import com.example.nexus.ui.theme.Dimens
import com.example.nexus.ui.theme.FontSizes
import com.example.nexus.ui.theme.Strings

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    currentRoute: String,
    selectedNewFilter: NewFilterType,
    canNavigateBack: Boolean,
    onBackClick: () -> Unit,
    onDownloadClick: () -> Unit,
    onSearchClick: () -> Unit,
    onFilterSelected: (String) -> Unit,
    onNewFilterSelected: (NewFilterType) -> Unit,
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
                    fontSize = FontSizes.titleSmall,
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
                            contentDescription = Strings.Icons.backIcon
                        )
                    }
                } else {
                    Image(
                        painter = painterResource(R.drawable.nexus_icon),
                        contentDescription = Strings.Icons.nexusIcon,
                        modifier = Modifier.size(Dimens.Icons.large)
                    )
                }
            },
            actions = {
                TopBarAction(
                    iconRes = R.drawable.cast_icon,
                    contentDescription = Strings.Icons.castIcon,
                    onClick = { }
                )
                TopBarAction(
                    iconRes = R.drawable.download_icon,
                    contentDescription = Strings.Icons.downloadIcon,
                    onClick = onDownloadClick
                )
                TopBarAction(
                    iconRes = R.drawable.search_icon,
                    contentDescription = Strings.Icons.searchIcon,
                    onClick = onSearchClick
                )
            },
            modifier = modifier
        )

        if (Destinations.shouldShowFilterBar(currentRoute)) {
            FilterBar(
                selectedFilter = currentRoute,
                onFilterSelected = onFilterSelected
            )
        }

        if (Destinations.shouldShowNewsFilterBar(currentRoute)) {
            NewsFilterBar(
                selectedNewFilter = selectedNewFilter,
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
            modifier = Modifier.size(Dimens.Icons.medium)
        )
    }
}