package com.example.nexus.ui.screens.games

import com.example.nexus.common.constants.MoviesGenreIds
import com.example.nexus.common.constants.NetworkConstants
import com.example.nexus.ui.theme.Strings

sealed class GameMovieCategory(
    val title: String,
    val genreId: String? = null,
    val page: Int = 1,
    val originCountry: String = NetworkConstants.ORIGIN_COUNTRY_US
) {
    object RecommendedMovies : GameMovieCategory(
        title = Strings.gamesMovieCategory.recommendedForYou,
        genreId = MoviesGenreIds.ANIMATION + NetworkConstants.AND + MoviesGenreIds.ADVENTURE + NetworkConstants.AND + MoviesGenreIds.COMEDY,
        page = 3,
        originCountry = NetworkConstants.ORIGIN_COUNTRY_US
    )

    object OnlyNexus : GameMovieCategory(
        title = Strings.gamesMovieCategory.onlyNexus,
        genreId = MoviesGenreIds.ANIMATION + NetworkConstants.AND + MoviesGenreIds.COMEDY + NetworkConstants.AND + MoviesGenreIds.FAMILY,
        page = 1,
        originCountry = NetworkConstants.ORIGIN_COUNTRY_US
    )

    object NewsNexus : GameMovieCategory(
        title = Strings.gamesMovieCategory.newsNexus,
        genreId = MoviesGenreIds.ANIMATION + NetworkConstants.AND + MoviesGenreIds.ADVENTURE + NetworkConstants.AND + MoviesGenreIds.FANTASY + NetworkConstants.AND + MoviesGenreIds.COMEDY + NetworkConstants.AND + MoviesGenreIds.FAMILY,
        page = 2,
        originCountry = NetworkConstants.ORIGIN_COUNTRY_US
    )

    object SelectionToday : GameMovieCategory(
        title = Strings.gamesMovieCategory.selectionToday,
        genreId = MoviesGenreIds.ADVENTURE + NetworkConstants.AND + MoviesGenreIds.FAMILY + NetworkConstants.AND + MoviesGenreIds.DRAMA,
        page = 1,
        originCountry = NetworkConstants.ORIGIN_COUNTRY_US
    )

    object Animation : GameMovieCategory(
        title = Strings.gamesMovieCategory.animation,
        genreId = MoviesGenreIds.ANIMATION,
        page = 4,
        originCountry = NetworkConstants.ORIGIN_COUNTRY_US
    )

    object TreasuresForYou : GameMovieCategory(
        title = Strings.gamesMovieCategory.treasuresForYou,
        genreId = MoviesGenreIds.ANIMATION + NetworkConstants.AND + MoviesGenreIds.FAMILY,
        page = 5,
        originCountry = NetworkConstants.ORIGIN_COUNTRY_US
    )

    object HollywoodYourScreen : GameMovieCategory(
        title = Strings.gamesMovieCategory.hollywoodYourScreen,
        genreId = MoviesGenreIds.COMEDY + NetworkConstants.AND + MoviesGenreIds.ANIMATION + NetworkConstants.AND + MoviesGenreIds.FAMILY + NetworkConstants.AND + MoviesGenreIds.SCIENCE_FICTION,
        page = 8,
        originCountry = NetworkConstants.ORIGIN_COUNTRY_US
    )

    object ChildrenMovies : GameMovieCategory(
        title = Strings.gamesMovieCategory.childrenMovies,
        genreId = MoviesGenreIds.ANIMATION + NetworkConstants.AND + MoviesGenreIds.ADVENTURE + NetworkConstants.AND + MoviesGenreIds.FAMILY + NetworkConstants.AND + MoviesGenreIds.COMEDY,
        page = 6,
        originCountry = NetworkConstants.ORIGIN_COUNTRY_US
    )

    object DramaMovies : GameMovieCategory(
        title = Strings.gamesMovieCategory.dramaMovies,
        genreId = MoviesGenreIds.ANIMATION + NetworkConstants.AND + MoviesGenreIds.ADVENTURE + NetworkConstants.AND + MoviesGenreIds.FAMILY + NetworkConstants.AND + MoviesGenreIds.DRAMA + NetworkConstants.AND + MoviesGenreIds.WESTERN,
        page = 7,
        originCountry = NetworkConstants.ORIGIN_COUNTRY_US
    )

    object MoviesForFamily : GameMovieCategory(
        title = Strings.gamesMovieCategory.moviesHollywood,
        genreId = MoviesGenreIds.COMEDY + NetworkConstants.AND + MoviesGenreIds.FAMILY,
        page = 5,
        originCountry = NetworkConstants.ORIGIN_COUNTRY_US
    )

    object WomenBehindScenes : GameMovieCategory(
        title = Strings.gamesMovieCategory.womenBehindScenes,
        genreId = MoviesGenreIds.COMEDY + NetworkConstants.AND + MoviesGenreIds.ROMANCE + NetworkConstants.AND + MoviesGenreIds.DRAMA,
        page = 4,
        originCountry = NetworkConstants.ORIGIN_COUNTRY_US
    )

    object AnimationForFamily : GameMovieCategory(
        title = Strings.gamesMovieCategory.animationForFamily,
        genreId = MoviesGenreIds.ANIMATION + NetworkConstants.AND + MoviesGenreIds.ADVENTURE + NetworkConstants.AND + MoviesGenreIds.COMEDY + NetworkConstants.AND + MoviesGenreIds.FAMILY + NetworkConstants.AND + MoviesGenreIds.FANTASY ,
        page = 3,
        originCountry = NetworkConstants.ORIGIN_COUNTRY_US
    )

    object ComedyMovies : GameMovieCategory(
        title = Strings.gamesMovieCategory.comedyMovies,
        genreId = MoviesGenreIds.ANIMATION + NetworkConstants.AND + MoviesGenreIds.COMEDY + NetworkConstants.AND + MoviesGenreIds.FAMILY,
        page = 1,
        originCountry = NetworkConstants.ORIGIN_COUNTRY_US
    )

    object WackyMovies : GameMovieCategory(
        title = Strings.gamesMovieCategory.wackyMovies,
        genreId = MoviesGenreIds.COMEDY + NetworkConstants.AND + MoviesGenreIds.ADVENTURE + NetworkConstants.AND + MoviesGenreIds.FANTASY + NetworkConstants.AND + MoviesGenreIds.ANIMATION + NetworkConstants.AND + MoviesGenreIds.FAMILY,
        page = 1,
        originCountry = NetworkConstants.ORIGIN_COUNTRY_US
    )

    object KillBoredom : GameMovieCategory(
        title = Strings.gamesMovieCategory.killBoredom,
        genreId = MoviesGenreIds.FANTASY + NetworkConstants.AND + MoviesGenreIds.MUSIC + NetworkConstants.AND + MoviesGenreIds.COMEDY + NetworkConstants.AND + MoviesGenreIds.ANIMATION,
        page = 1,
        originCountry = NetworkConstants.ORIGIN_COUNTRY_KR
    )
}