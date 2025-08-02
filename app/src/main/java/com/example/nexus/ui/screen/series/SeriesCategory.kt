package com.example.nexus.ui.screen.series

import com.example.nexus.data.remote.constants.SeriesGenreIds

sealed class SeriesCategory(val title: String, val genreId: Int? = null) {
    object AiringToday : SeriesCategory("Las series de estreno")
    object OnTheAir : SeriesCategory("Las series actuales")
    object Popular : SeriesCategory("Las series más populares")
    object TopRated : SeriesCategory("Las mejores 10 series")

    object Action : SeriesCategory("Series de Acción y Aventura", SeriesGenreIds.ACTION_ADVENTURE)
    object Animation : SeriesCategory("Series de Animación", SeriesGenreIds.ANIMATION)
    object Comedy : SeriesCategory("Series de Comedia", SeriesGenreIds.COMEDY)
    object Crime : SeriesCategory("Series de Crimenes", SeriesGenreIds.CRIME)
    object Documentary : SeriesCategory("Series Documentales", SeriesGenreIds.DOCUMENTARY)
    object Drama : SeriesCategory("Series de Drama", SeriesGenreIds.DRAMA)
    object Family : SeriesCategory("Series para la Familia", SeriesGenreIds.FAMILY)
    object Kids : SeriesCategory("Series para Niños", SeriesGenreIds.KIDS)
    object Mystery : SeriesCategory("Series de Misterio", SeriesGenreIds.MYSTERY)
    object News : SeriesCategory("Series Nuevas", SeriesGenreIds.NEWS)
    object Reality : SeriesCategory("Series de Reality", SeriesGenreIds.REALITY)
    object ScienceFiction : SeriesCategory("Series de Ciencia Ficción", SeriesGenreIds.SCIENCE_FICTION)
    object Soap : SeriesCategory("Series de Telenovelas", SeriesGenreIds.SOAP)
    object Talk : SeriesCategory("Series de Podcast", SeriesGenreIds.TALK)
    object War : SeriesCategory("Series de Guerra", SeriesGenreIds.WAR)
    object Western : SeriesCategory("Series de Occidente", SeriesGenreIds.WESTERN)
}
