package com.example.nexus.ui.screens.movies

import com.example.nexus.common.constants.MoviesGenreIds
import com.example.nexus.common.constants.NetworkConstants
import com.example.nexus.ui.theme.Strings

sealed class MovieCategory(
    val title: String,
    val genreId: String? = null,
    val page: Int = 1,
    val originCountry: String = NetworkConstants.ORIGINAL_COUNTRY_US
) {
    object UpComing : MovieCategory(
        title = Strings.movieCategory.upcoming
    )

    object Thriller : MovieCategory(
        title = Strings.movieCategory.thriller,
        genreId = MoviesGenreIds.THRILLER,
        page = 1
    )

    object NewHistory : MovieCategory(
        title = Strings.movieCategory.newHistory,
        genreId = MoviesGenreIds.ACTION,
        page = 1
    )

    object ActionAndDrama : MovieCategory(
        title = Strings.movieCategory.actionAndDrama,
        genreId = MoviesGenreIds.ACTION + NetworkConstants.AND + MoviesGenreIds.DRAMA,
        page = 2
    )

    object ActionComedy : MovieCategory(
        title = Strings.movieCategory.actionComedy,
        genreId = MoviesGenreIds.ACTION + NetworkConstants.AND + MoviesGenreIds.COMEDY,
        page = 1
    )

    object OnlyNexus : MovieCategory(
        title = Strings.movieCategory.onlyNexus,
        genreId = MoviesGenreIds.ADVENTURE + NetworkConstants.AND + MoviesGenreIds.DRAMA
    )

    object NowPlaying : MovieCategory(
        title = Strings.movieCategory.nowPlaying
    )

    object Comedy : MovieCategory(
        title = Strings.movieCategory.family,
        genreId = MoviesGenreIds.COMEDY,
        page = 2
    )

    object Action : MovieCategory(
        title = Strings.movieCategory.action,
        genreId = MoviesGenreIds.ACTION,
        page = 2
    )

    object ActionAndThriller : MovieCategory(
        title = Strings.movieCategory.actionAndThriller,
        genreId = MoviesGenreIds.ACTION + NetworkConstants.AND + MoviesGenreIds.ADVENTURE + NetworkConstants.AND + MoviesGenreIds.THRILLER
    )

    object Drama : MovieCategory(
        title = Strings.movieCategory.drama,
        genreId = MoviesGenreIds.DRAMA
    )

    object DramaAndDocumentary : MovieCategory(
        title = Strings.movieCategory.dramaAndDocumentary,
        genreId = MoviesGenreIds.DRAMA + NetworkConstants.AND + MoviesGenreIds.DOCUMENTARY
    )

    object Terror : MovieCategory(
        title = Strings.movieCategory.terror,
        genreId = MoviesGenreIds.HORROR,
        page = 1
    )

    object SciFiAndFantasy : MovieCategory(
        title = Strings.movieCategory.sciFiAndFantasy,
        genreId = MoviesGenreIds.SCIENCE_FICTION + NetworkConstants.AND + MoviesGenreIds.FANTASY
    )

    object Thriller2 : MovieCategory(
        title = Strings.movieCategory.thriller2,
        genreId = MoviesGenreIds.THRILLER,
        page = 2
    )

    object ScienceFiction : MovieCategory(
        title = Strings.movieCategory.scienceFiction,
        genreId = MoviesGenreIds.SCIENCE_FICTION,
        page = 1
    )

    object Crime : MovieCategory(
        title = Strings.movieCategory.crime,
        genreId = MoviesGenreIds.CRIME
    )

    object TvMovie : MovieCategory(
        title = Strings.movieCategory.tvMovie,
        genreId = MoviesGenreIds.TV_MOVIE
    )

    object WarAndThriller : MovieCategory(
        title = Strings.movieCategory.warAndThriller,
        genreId = MoviesGenreIds.THRILLER + NetworkConstants.AND + MoviesGenreIds.WAR
    )

    object DramaArgentina : MovieCategory(
        title = Strings.movieCategory.dramaArgentina,
        genreId = MoviesGenreIds.DRAMA,
        page = 1,
        originCountry = NetworkConstants.ORIGINAL_COUNTRY_AR
    )

    object Comedy2 : MovieCategory(
        title = Strings.movieCategory.comedy2,
        genreId = MoviesGenreIds.COMEDY,
        page = 1
    )

    object Horror : MovieCategory(
        title = Strings.movieCategory.horror,
        genreId = MoviesGenreIds.HORROR,
        page = 2
    )

    object ActionKorea : MovieCategory(
        title = Strings.movieCategory.actionKorea,
        genreId = MoviesGenreIds.ACTION + NetworkConstants.AND + MoviesGenreIds.DRAMA,
        page = 1,
        originCountry = NetworkConstants.ORIGINAL_COUNTRY_KR
    )

    object Drama2 : MovieCategory(
        title = Strings.movieCategory.drama2,
        genreId = MoviesGenreIds.DRAMA,
        page = 2
    )

    object ActionAndSciFi : MovieCategory(
        title = Strings.movieCategory.actionAndSciFi,
        genreId = MoviesGenreIds.ACTION + NetworkConstants.AND + MoviesGenreIds.SCIENCE_FICTION
    )

    object TaqAction : MovieCategory(
        title = Strings.movieCategory.taqAction,
        genreId = MoviesGenreIds.ACTION,
        page = 3
    )

    object Romance : MovieCategory(
        title = Strings.movieCategory.romance,
        genreId = MoviesGenreIds.ROMANCE
    )

    object Trending : MovieCategory(
        title = Strings.movieCategory.trending
    )

    object Popular : MovieCategory(
        title = Strings.movieCategory.popular
    )

    object War : MovieCategory(
        title = Strings.movieCategory.war,
        genreId = MoviesGenreIds.WAR
    )

    object Mystery : MovieCategory(
        title = Strings.movieCategory.mystery,
        genreId = MoviesGenreIds.MYSTERY
    )

    object Adventure : MovieCategory(
        title = Strings.movieCategory.adventure,
        genreId = MoviesGenreIds.ADVENTURE
    )

    object Fantasy : MovieCategory(
        title = Strings.movieCategory.fantasy,
        genreId = MoviesGenreIds.FANTASY
    )

    object Western : MovieCategory(
        title = Strings.movieCategory.western,
        genreId = MoviesGenreIds.WESTERN
    )

    object Mexican : MovieCategory(
        title = Strings.movieCategory.mexican,
        genreId = MoviesGenreIds.ACTION + NetworkConstants.OR + MoviesGenreIds.DRAMA,
        page = 1,
        originCountry = NetworkConstants.ORIGINAL_COUNTRY_MX
    )

    object Family : MovieCategory(
        title = Strings.movieCategory.family,
        genreId = MoviesGenreIds.FAMILY
    )

    object Animation : MovieCategory(
        title = Strings.movieCategory.animation,
        genreId = MoviesGenreIds.ANIMATION
    )
}