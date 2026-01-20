package com.example.nexus.ui.screens.games

import com.example.nexus.common.constants.NetworkConstants
import com.example.nexus.common.constants.SeriesGenreIds
import com.example.nexus.ui.theme.Strings

sealed class GameSerieCategory(
    val title: String,
    val genreId: String? = null,
    val page: Int = 1,
    val originCountry: String = NetworkConstants.ORIGIN_COUNTRY_US
) {
    object NextHistory : GameSerieCategory(
        title = Strings.gamesSerieCategory.nextHistory,
        genreId = SeriesGenreIds.ANIMATION,
        page = 1,
        originCountry = NetworkConstants.ORIGIN_COUNTRY_US
    )

    object ExcitingSeries : GameSerieCategory(
        title = Strings.gamesSerieCategory.excitingSerie,
        genreId = SeriesGenreIds.ANIMATION + NetworkConstants.AND + SeriesGenreIds.ACTION_ADVENTURE + NetworkConstants.AND + SeriesGenreIds.SCI_FI_FANTASY,
        page = 1,
        originCountry = NetworkConstants.ORIGIN_COUNTRY_JP
    )

    object DramaSeries : GameSerieCategory(
        title = Strings.gamesSerieCategory.dramaSeries,
        genreId = SeriesGenreIds.DRAMA + NetworkConstants.AND + SeriesGenreIds.FAMILY + NetworkConstants.AND + SeriesGenreIds.KIDS,
        page = 5,
        originCountry = NetworkConstants.ORIGIN_COUNTRY_US
    )

    object ChildrensContent : GameSerieCategory(
        title = Strings.gamesSerieCategory.childrensContent,
        genreId = SeriesGenreIds.COMEDY + NetworkConstants.AND + SeriesGenreIds.KIDS + NetworkConstants.AND + SeriesGenreIds.FAMILY,
        page = 1,
        originCountry = NetworkConstants.ORIGIN_COUNTRY_US
    )

    object Cartoon : GameSerieCategory(
        title = Strings.gamesSerieCategory.cartoon,
        genreId = SeriesGenreIds.ANIMATION + NetworkConstants.AND + SeriesGenreIds.KIDS,
        page = 1,
        originCountry = NetworkConstants.ORIGIN_COUNTRY_US
    )

    object ComedySeries : GameSerieCategory(
        title = Strings.gamesSerieCategory.seriesComedy,
        genreId = SeriesGenreIds.COMEDY + NetworkConstants.AND + SeriesGenreIds.KIDS,
        page = 1,
        originCountry = NetworkConstants.ORIGIN_COUNTRY_US
    )

    object KidsNotKids : GameSerieCategory(
        title = Strings.gamesSerieCategory.kidsNotKids,
        genreId = SeriesGenreIds.ACTION_ADVENTURE + NetworkConstants.AND + SeriesGenreIds.SCI_FI_FANTASY + NetworkConstants.AND + SeriesGenreIds.KIDS,
        page = 2,
        originCountry = NetworkConstants.ORIGIN_COUNTRY_US
    )

    object SeriesBasedOnBooks : GameSerieCategory(
        title = Strings.gamesSerieCategory.seriesBasedOnBooks,
        genreId = SeriesGenreIds.ANIMATION + NetworkConstants.AND + SeriesGenreIds.ACTION_ADVENTURE + NetworkConstants.AND + SeriesGenreIds.COMEDY + NetworkConstants.AND + SeriesGenreIds.KIDS,
        page = 1,
        originCountry = NetworkConstants.ORIGIN_COUNTRY_US
    )

    object SeriesSpanish : GameSerieCategory(
        title = Strings.gamesSerieCategory.seriesSpanish,
        genreId = SeriesGenreIds.DRAMA + NetworkConstants.AND + SeriesGenreIds.COMEDY,
        page = 1,
        originCountry = NetworkConstants.ORIGIN_COUNTRY_MX
    )

    object CuriousMinds : GameSerieCategory(
        title = Strings.gamesSerieCategory.curiousMinds,
        genreId = SeriesGenreIds.DOCUMENTARY + NetworkConstants.AND + SeriesGenreIds.FAMILY,
        page = 2,
        originCountry = NetworkConstants.ORIGIN_COUNTRY_US
    )

    object ActionSeries : GameSerieCategory(
        title = Strings.gamesSerieCategory.actionSeries,
        genreId = SeriesGenreIds.ANIMATION + NetworkConstants.AND + SeriesGenreIds.ACTION_ADVENTURE + NetworkConstants.AND + SeriesGenreIds.COMEDY + NetworkConstants.AND + SeriesGenreIds.SCI_FI_FANTASY,
        page = 1,
        originCountry = NetworkConstants.ORIGIN_COUNTRY_US
    )

    object FantasySeries : GameSerieCategory(
        title = Strings.gamesSerieCategory.fantasySeries,
        genreId = SeriesGenreIds.SCI_FI_FANTASY + NetworkConstants.AND + SeriesGenreIds.KIDS + NetworkConstants.AND + SeriesGenreIds.COMEDY + NetworkConstants.AND + SeriesGenreIds.FAMILY,
        page = 1,
        originCountry = NetworkConstants.ORIGIN_COUNTRY_AU
    )
}