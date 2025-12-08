package com.example.nexus.ui.theme

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object Dimens {

    object Padding {
        val tiny = 1.dp
        val mini = 2.dp
        val extraSmall = 3.dp
        val small = 4.dp
        val medium = 5.dp
        val compact = 7.dp
        val standard = 10.dp
        val regular = 12.dp
        val base = 13.dp
        val large = 14.dp
        val extraLarge = 16.dp
        val huge = 50.dp
    }

    object Spacing {
        val extraSmall = 4.dp
        val compact = 5.dp
        val small = 6.dp
        val medium = 8.dp
        val regular = 9.dp
        val large = 13.dp
        val extraLarge = 15.dp
        val jumbo = 16.dp
    }

    object Radius {
        val extraSmall = 2.dp
        val small = 4.dp
        val medium = 11.dp
        val regular = 13.dp
        val large = 18.dp
    }

    object Border {
        val extraSmall = 0.5.dp
        val small = 1.dp
    }

    object Alpha {
        const val EXTRA_SMALL = 0.45f
        const val SMALL = 0.50f
        const val MEDIUM = 0.60f
    }

    data class PosterSize(
        val width: Dp,
        val height: Dp
    )

    object Poster {
        val small = PosterSize(width = 116.dp, height = 162.dp)
        val large = PosterSize(width = 360.dp, height = 495.dp)
    }

    object Elevation {
        val medium = 15.dp
    }

    data class ButtonSize(
        val width: Dp,
        val height: Dp
    )

    object Buttons {
        val large = ButtonSize(width = 157.dp, height = 38.dp)
        val extraLarge = ButtonSize(width = 157.dp, height = 50.dp)
    }

    object IconSize {
        val extraSmall = 18.dp
        val small = 26.dp
        val medium = 27.dp
        val regular = 33.dp
        val large = 43.dp
    }

    data class FilterSize(
        val width: Dp,
        val height: Dp
    )

    object Filter {
        val small = FilterSize(width = 40.dp, height = 40.dp)
        val medium = FilterSize(width = 88.dp, height = 48.dp)
        val large = FilterSize(width = 110.dp, height = 48.dp)
    }

    object BarSize {
        val large = 110.dp
    }

    object AspectRatio {
        const val SMALL = 1.7f
    }

}