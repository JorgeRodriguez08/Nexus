package com.example.nexus.ui.theme

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object Dimens {
    object Padding {
        val hairline = 1.dp
        val micro = 2.dp
        val extraSmall = 4.dp
        val small = 6.dp
        val medium = 8.dp
        val base = 10.dp
        val large = 12.dp
        val extraLarge = 14.dp
        val extraExtraLarge = 16.dp
        val gigaLarge = 18.dp
        val sectionSmall = 20.dp
        val sectionMedium = 24.dp
        val sectionLarge = 32.dp
        val hero = 50.dp
    }

    object Radius {
        val micro = 2.dp
        val extraSmall = 4.dp
        val small = 6.dp
        val base = 10.dp
        val large = 12.dp
        val gigaLarge = 18.dp
    }

    object Elevation {
        val extraLarge = 15.dp
    }

    object Borders {
        val thin = 0.5.dp
        val hairline = 1.dp
    }

    object Alpha {
        const val hover = 0.05f
        const val pressed = 0.20f
        const val regular = 0.30f
        const val disabled = 0.40f
        const val medium = 0.60f
    }

    data class Size(
        val width: Dp,
        val height: Dp
    )

    object Posters {
        val mini = Size(40.dp, 23.dp)
        val extraExtraSmall = Size(55.dp, 55.dp)
        val extraSmall = Size(116.dp, 116.dp)
        val small = Size(116.dp, 162.dp)
        val top = Size(127.dp, 177.dp)
        val medium = Size(145.dp, 225.dp)
        val regular = Size(178.dp, 350.dp)
        val large = Size(214.dp, 214.dp)
        val extraLarge = Size(360.dp, 496.dp)
        val extraExtraLarge = Size(388.dp, 388.dp)
    }

    object Box {
        val small = Size(48.dp, 48.dp)
        val medium = Size(81.dp, 81.dp)
    }

    object Buttons {
        val medium = Size(158.dp, 38.dp)
        val regular = Size(155.dp, 47.dp)
        val large = Size(158.dp, 50.dp)
    }

    object Icons {
        val small = 18.dp
        val medium = 26.dp
        val regular = 28.dp
        val large = 32.dp
        val base = 38.dp
        val extraLarge = 42.dp
    }

    object Filters {
        val small = Size(40.dp, 40.dp)
        val medium = Size(88.dp, 48.dp)
        val large = Size(110.dp, 48.dp)
    }

    object Bar {
        val large = 110.dp
    }

    object AspectRatio {
        const val poster = 1.7f
    }
}