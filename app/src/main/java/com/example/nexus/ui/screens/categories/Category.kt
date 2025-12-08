package com.example.nexus.ui.screens.categories

sealed class Category(val title: String) {
    object Action : Category("Action")
    object Adventure : Category("Aventura")
    object Animation : Category("Animación")
    object Comedy : Category("Comedia")
    object Crime : Category("Crimen")
    object Documentary : Category("Documental")
    object Drama : Category("Drama")
    object Family : Category("Familia")
    object Fantasy : Category("Fantasía")
    object History : Category("Historia")
    object Horror : Category("Horror")
    object Music : Category("Musica")
    object Mystery : Category("Misterio")
    object Romance : Category("Romance")
    object ScienceFiction : Category("Ciencia Ficción")
    object TvMovie : Category("Tv-Movie")
    object Thriller : Category("Thriller")
    object War : Category("Guerra")
    object Western : Category("Occidente")
}