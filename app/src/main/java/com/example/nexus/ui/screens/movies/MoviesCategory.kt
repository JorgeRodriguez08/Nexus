package com.example.nexus.ui.screens.movies

import com.example.nexus.common.constants.MoviesGenreIds

sealed class MoviesCategory(val title: String, val genreId: String? = null) {
    object NowPlaying : MoviesCategory("Las películas de estreno")
    object Popular : MoviesCategory("Las películas más populares")
    object TopRated : MoviesCategory("Las 10 mejores películas")
    object UpComing : MoviesCategory("Películas Proximamente")

    object Action : MoviesCategory("Películas de Acción", MoviesGenreIds.ACTION)
    object Adventure : MoviesCategory("Películas de Aventura", MoviesGenreIds.ADVENTURE)
    object Animation : MoviesCategory("Películas de Animación", MoviesGenreIds.ANIMATION)
    object Comedy : MoviesCategory("Películas de Comedia", MoviesGenreIds.COMEDY)
    object Crime : MoviesCategory("Películas de Crimen", MoviesGenreIds.CRIME)
    object Documentary : MoviesCategory("Películas de Documentales", MoviesGenreIds.DOCUMENTARY)
    object Drama : MoviesCategory("Películas de Drama", MoviesGenreIds.DRAMA)
    object Family : MoviesCategory("Películas para la Familia", MoviesGenreIds.FAMILY)
    object Fantasy : MoviesCategory("Películas de Fantasía", MoviesGenreIds.FANTASY)
    object History : MoviesCategory("Películas de Historia", MoviesGenreIds.HISTORY)
    object Horror : MoviesCategory("Películas de Horror", MoviesGenreIds.HORROR)
    object Music : MoviesCategory("Películas de Música", MoviesGenreIds.MUSIC)
    object Mystery : MoviesCategory("Películas de Misterio", MoviesGenreIds.MYSTERY)
    object Romance : MoviesCategory("Películas de Romance", MoviesGenreIds.ROMANCE)
    object ScienceFiction : MoviesCategory("Películas de Ciencia Ficción", MoviesGenreIds.SCIENCE_FICTION)
    object TvMovie : MoviesCategory("Películas de TV Movie", MoviesGenreIds.TV_MOVIE)
    object Thriller : MoviesCategory("Películas de Suspenso", MoviesGenreIds.THRILLER)
    object War : MoviesCategory("Películas de Guerra", MoviesGenreIds.WAR)
    object Western : MoviesCategory("Películas de Occidente", MoviesGenreIds.WESTERN)
}