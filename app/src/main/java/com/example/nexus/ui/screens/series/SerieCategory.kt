package com.example.nexus.ui.screens.series

import com.example.nexus.common.constants.NetworkConstants
import com.example.nexus.common.constants.SeriesGenreIds
import com.example.nexus.ui.screens.newsPopular.NewsMovieLayout
import com.example.nexus.ui.theme.Strings

sealed class SerieCategory(
    val title: String,
    val genreId: String? = null,
    val page: Int = 1,
    val originCountry: String = NetworkConstants.ORIGINAL_COUNTRY_US
) {
    object Trending : SerieCategory(
        title = Strings.serieCategory.trending
    )

    object News : SerieCategory(
        title = Strings.serieCategory.news,
        genreId = SeriesGenreIds.NEWS
    )

    object Crime : SerieCategory(
        title = Strings.serieCategory.crime,
        genreId = SeriesGenreIds.CRIME
    )

    object AiringToday : SerieCategory(
        title = Strings.serieCategory.airingToday
    )

    object OnTheAir : SerieCategory(
        title = Strings.serieCategory.onTheAir
    )

    object Romantic : SerieCategory(
        title = Strings.serieCategory.romantic,
        genreId = SeriesGenreIds.DRAMA
    )

    object RomanticAsiatic : SerieCategory(
        title = Strings.serieCategory.romanticAsiatic,
        genreId = SeriesGenreIds.DRAMA,
        page = 1,
        originCountry = NetworkConstants.ORIGINAL_COUNTRY_KR
    )

    object ActionAdventure : SerieCategory(
        title = Strings.serieCategory.actionAdventure,
        genreId = SeriesGenreIds.ACTION_ADVENTURE
    )

    object RomanticKorea : SerieCategory(
        title = Strings.serieCategory.romanticKorea,
        genreId = SeriesGenreIds.DRAMA,
        page = 2,
        originCountry = NetworkConstants.ORIGINAL_COUNTRY_KR
    )

    object Family : SerieCategory(
        title = Strings.serieCategory.family,
        genreId = SeriesGenreIds.FAMILY
    )

    object Action : SerieCategory(
        title = Strings.serieCategory.action,
        genreId = SeriesGenreIds.ACTION_ADVENTURE,
        page = 2
    )

    object Comedy : SerieCategory(
        title = Strings.serieCategory.comedy,
        genreId = SeriesGenreIds.COMEDY,
        page = 1
    )

    object Drama : SerieCategory(
        title = Strings.serieCategory.drama,
        genreId = SeriesGenreIds.DRAMA,
        originCountry = NetworkConstants.ORIGINAL_COUNTRY_AR
    )

    object DramaKorea : SerieCategory(
        title = Strings.serieCategory.dramaKorea,
        genreId = SeriesGenreIds.DRAMA,
        page = 1,
        originCountry = NetworkConstants.ORIGINAL_COUNTRY_KR
    )

    object DramaUs : SerieCategory(
        title = Strings.serieCategory.dramaUs,
        genreId = SeriesGenreIds.DRAMA,
        page = 1,
        originCountry = NetworkConstants.ORIGINAL_COUNTRY_US
    )

    object DramaAndThriller : SerieCategory(
        title = Strings.serieCategory.dramaAndThriller,
        genreId = SeriesGenreIds.DRAMA + NetworkConstants.AND + SeriesGenreIds.CRIME,
        page = 2,
        originCountry = NetworkConstants.ORIGINAL_COUNTRY_KR
    )

    object Telenovela : SerieCategory(
        title = Strings.serieCategory.telenovela,
        genreId = SeriesGenreIds.DRAMA,
        page = 1,
        originCountry = NetworkConstants.ORIGINAL_COUNTRY_MX
    )

    object Mystery : SerieCategory(
        title = Strings.serieCategory.mystery,
        genreId = SeriesGenreIds.MYSTERY
    )

    object OnlyNexus : SerieCategory(
        title = Strings.serieCategory.onlyNexus,
        genreId = SeriesGenreIds.ACTION_ADVENTURE,
        page = 1
    )

    object SeriesKr : SerieCategory(
        title = Strings.serieCategory.seriesKr,
        genreId = SeriesGenreIds.MYSTERY,
        page = 1,
        originCountry = NetworkConstants.ORIGINAL_COUNTRY_KR
    )

    object SciFiFantasy : SerieCategory(
        title = Strings.serieCategory.sciFiFantasy,
        genreId = SeriesGenreIds.SCI_FI_FANTASY
    )

    object SeriesUs : SerieCategory(
        title = Strings.serieCategory.seriesUs,
        genreId = SeriesGenreIds.ACTION_ADVENTURE
    )

    object SeriesLatam : SerieCategory(
        title = Strings.serieCategory.seriesLatam,
        genreId = SeriesGenreIds.MYSTERY,
        page = 1,
        originCountry = NetworkConstants.ORIGINAL_COUNTRY_MX
    )

    object Kids : SerieCategory(
        title = Strings.serieCategory.kids,
        genreId = SeriesGenreIds.KIDS
    )

    object SeriesMex : SerieCategory(
        title = Strings.serieCategory.seriesMex,
        genreId = SeriesGenreIds.DRAMA,
        page = 1,
        originCountry = NetworkConstants.ORIGINAL_COUNTRY_MX
    )

    object Thriller : SerieCategory(
        title = Strings.serieCategory.thriller,
        genreId = SeriesGenreIds.CRIME,
        page = 2
    )

    object ThrillerAndMystery : SerieCategory(
        title = Strings.serieCategory.thrillerAndMystery,
        genreId = SeriesGenreIds.CRIME + NetworkConstants.AND + SeriesGenreIds.MYSTERY,
        page = 1,
        originCountry = NetworkConstants.ORIGINAL_COUNTRY_US
    )

    object Popular : SerieCategory(
        title = Strings.serieCategory.popular
    )

    object RomanticInter : SerieCategory(
        title = Strings.serieCategory.romanticInter,
        genreId = SeriesGenreIds.DRAMA,
        page = 3,
        originCountry = NetworkConstants.ORIGINAL_COUNTRY_KR
    )

    object War : SerieCategory(
        title = Strings.serieCategory.war,
        genreId = SeriesGenreIds.WAR_POLITICS
    )

    object Dark : SerieCategory(
        title = Strings.serieCategory.dark,
        genreId = SeriesGenreIds.CRIME,
        page = 2
    )

    object Animation : SerieCategory(
        title = Strings.serieCategory.animation,
        genreId = SeriesGenreIds.ANIMATION,
    )

    object Talk : SerieCategory(
        title = Strings.serieCategory.talk,
        genreId = SeriesGenreIds.TALK,
    )

    object Police : SerieCategory(
        title = Strings.serieCategory.police,
        genreId = SeriesGenreIds.ACTION_ADVENTURE + NetworkConstants.AND + SeriesGenreIds.DRAMA + NetworkConstants.AND + SeriesGenreIds.CRIME,
        page = 1,
        originCountry = NetworkConstants.ORIGINAL_COUNTRY_US
    )
}