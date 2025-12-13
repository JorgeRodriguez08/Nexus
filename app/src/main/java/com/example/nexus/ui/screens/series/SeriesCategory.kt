package com.example.nexus.ui.screens.series

import com.example.nexus.common.constants.SeriesGenreIds

sealed class SeriesCategory(val title: String, val genreId: String? = null) {
    object AiringToday : SeriesCategory("Las series de estreno")
    object OnTheAir : SeriesCategory("Las series actuales")
    object Popular : SeriesCategory("Las series más populares")
    object TopRated : SeriesCategory("Las mejores 10 series")

    object Action : SeriesCategory("Serie de Acción y Aventura", SeriesGenreIds.ACTION_ADVENTURE)
    object Animation : SeriesCategory("Serie de Animación", SeriesGenreIds.ANIMATION)
    object Comedy : SeriesCategory("Serie de Comedia", SeriesGenreIds.COMEDY)
    object Crime : SeriesCategory("Serie de Crimenes", SeriesGenreIds.CRIME)
    object Documentary : SeriesCategory("Serie Documentales", SeriesGenreIds.DOCUMENTARY)
    object Drama : SeriesCategory("Serie de Drama", SeriesGenreIds.DRAMA)
    object Family : SeriesCategory("Serie para la Familia", SeriesGenreIds.FAMILY)
    object Kids : SeriesCategory("Serie para Niños", SeriesGenreIds.KIDS)
    object Mystery : SeriesCategory("Serie de Misterio", SeriesGenreIds.MYSTERY)
    object News : SeriesCategory("Serie Nuevas", SeriesGenreIds.NEWS)
    object Reality : SeriesCategory("Serie de Reality", SeriesGenreIds.REALITY)
    object ScienceFiction : SeriesCategory("Serie de Ciencia Ficción", SeriesGenreIds.SCI_FI_FANTASY)
    object Soap : SeriesCategory("Serie de Telenovelas", SeriesGenreIds.SOAP)
    object Talk : SeriesCategory("Serie de Podcast", SeriesGenreIds.TALK)
    object War : SeriesCategory("Serie de Guerra", SeriesGenreIds.WAR_POLITICS)
    object Western : SeriesCategory("Serie de Occidente", SeriesGenreIds.WESTERN)
}
