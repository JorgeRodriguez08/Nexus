package com.example.nexus.ui.screens.categories

import com.example.nexus.data.remote.constants.CategoriesGenreIds

sealed class Category(val title: String, val genreId: Int) {
    object Action : Category("Action", CategoriesGenreIds.ACTION)
    object Adventure : Category("Aventura", CategoriesGenreIds.ADVENTURE)
    object Animation : Category("Animación", CategoriesGenreIds.ANIMATION)
    object Comedy : Category("Comedia", CategoriesGenreIds.COMEDY)
    object Crime : Category("Crimen", CategoriesGenreIds.CRIME)
    object Documentary : Category("Documental", CategoriesGenreIds.DOCUMENTARY)
    object Drama : Category("Drama", CategoriesGenreIds.DRAMA)
    object Family : Category("Familia", CategoriesGenreIds.FAMILY)
    object Fantasy : Category("Fantasía", CategoriesGenreIds.FANTASY)
    object History : Category("Historia", CategoriesGenreIds.HISTORY)
    object Horror : Category("Horror", CategoriesGenreIds.HORROR)
    object Music : Category("Musica", CategoriesGenreIds.MUSIC)
    object Mystery : Category("Misterio", CategoriesGenreIds.MYSTERY)
    object Romance : Category("Romance", CategoriesGenreIds.ROMANCE)
    object ScienceFiction : Category("Ciencia Ficción", CategoriesGenreIds.SCIENCE_FICTION)
    object TvMovie : Category("Tv-Movie", CategoriesGenreIds.TV_MOVIE)
    object Thriller : Category("Thriller", CategoriesGenreIds.THRILLER)
    object War : Category("Guerra", CategoriesGenreIds.WAR)
    object Western : Category("Occidente", CategoriesGenreIds.WESTERN)
}