package com.example.nexus.ui.screens.categories

import com.example.nexus.common.constants.MoviesGenreIds

sealed class Category(val title: String, val genreId: String) {
    object Action : Category("Action", MoviesGenreIds.ACTION)
    object Adventure : Category("Aventura", MoviesGenreIds.ADVENTURE)
    object Animation : Category("Animación", MoviesGenreIds.ANIMATION)
    object Comedy : Category("Comedia", MoviesGenreIds.COMEDY)
    object Crime : Category("Crimen", MoviesGenreIds.CRIME)
    object Documentary : Category("Documental", MoviesGenreIds.DOCUMENTARY)
    object Drama : Category("Drama", MoviesGenreIds.DRAMA)
    object Family : Category("Familia", MoviesGenreIds.FAMILY)
    object Fantasy : Category("Fantasía", MoviesGenreIds.FANTASY)
    object History : Category("Historia", MoviesGenreIds.HISTORY)
    object Horror : Category("Horror", MoviesGenreIds.HORROR)
    object Music : Category("Musica", MoviesGenreIds.MUSIC)
    object Mystery : Category("Misterio", MoviesGenreIds.MYSTERY)
    object Romance : Category("Romance", MoviesGenreIds.ROMANCE)
    object ScienceFiction : Category("Ciencia Ficción", MoviesGenreIds.SCIENCE_FICTION)
    object TvMovie : Category("Tv-Movie", MoviesGenreIds.TV_MOVIE)
    object Thriller : Category("Thriller", MoviesGenreIds.THRILLER)
    object War : Category("Guerra", MoviesGenreIds.WAR)
    object Western : Category("Occidente", MoviesGenreIds.WESTERN)
}