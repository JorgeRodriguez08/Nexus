package com.example.nexus.ui.screens.series

import com.example.nexus.constants.NetworkConstants
import com.example.nexus.constants.SerieGenreId

sealed class SerieCategory(val title: String, val genreId: String? = null, val page: Int = 1, val originCountry: String = NetworkConstants.ORIGIN_COUNTRY_US) {
    object Trending : SerieCategory("Las 10 series más populares hoy")
    object News : SerieCategory("Lo nuevo en Nexus", SerieGenreId.NEWS)
    object Crime : SerieCategory("Dramas implacables sobre crímenes", SerieGenreId.CRIME)
    object AiringToday : SerieCategory("Para pasar el rato")
    object OnTheAir : SerieCategory("Tu próxima historia")
    object Romantic : SerieCategory("Series románticas", SerieGenreId.DRAMA)
    object RomanticAsiatic : SerieCategory("Series románticas asiáticas", SerieGenreId.DRAMA, 1, NetworkConstants.ORIGINAL_COUNTRY_KR)
    object ActionAdventure : SerieCategory("Series emocionantes", SerieGenreId.ACTION_ADVENTURE)
    object RomanticKorea : SerieCategory("Series románticas coreanas", SerieGenreId.DRAMA, 2, NetworkConstants.ORIGINAL_COUNTRY_KR)
    object Family : SerieCategory("Series para ver en familia", SerieGenreId.FAMILY)
    object Action : SerieCategory("Series de Acción y Aventura", SerieGenreId.ACTION_ADVENTURE, 2)
    object Comedy : SerieCategory("Series de Comedia", SerieGenreId.COMEDY)
    object Telenovela : SerieCategory("Series románticas", SerieGenreId.DRAMA, 1,NetworkConstants.ORIGINAL_COUNTRY_MX)
    object Mystery : SerieCategory("Series sombrías", SerieGenreId.MYSTERY)
    object SeriesKr : SerieCategory("Series coreanas", SerieGenreId.MYSTERY, 1, NetworkConstants.ORIGINAL_COUNTRY_KR)
    object SciFiFantasy : SerieCategory("Nuestra selección de hoy para ti", SerieGenreId.SCI_FI_FANTASY)
    object SeriesUs : SerieCategory("Series de EE.UU", SerieGenreId.ACTION_ADVENTURE)
    object SeriesLatam : SerieCategory("Series lationamericanas", SerieGenreId.MYSTERY,1, NetworkConstants.ORIGINAL_COUNTRY_MX)
    object Kids : SerieCategory("Para ver con peques no tan peques", SerieGenreId.KIDS)
    object SeriesMex : SerieCategory("Series mexicanas", SerieGenreId.DRAMA, 1, NetworkConstants.ORIGINAL_COUNTRY_MX)
    object Thriller : SerieCategory("Para aniquilar el aburrimiento", SerieGenreId.CRIME, 2)
    object Popular : SerieCategory("Series aclamadas por la crítica")
    object RomanticInter : SerieCategory("Series internacionales románticas", SerieGenreId.DRAMA, 3, NetworkConstants.ORIGINAL_COUNTRY_KR)
    object War : SerieCategory("Para aniquilar el aburrimiento", SerieGenreId.WAR_POLITICS)
    object Dark : SerieCategory("Series dramáticas sombrías de EE.UU", SerieGenreId.CRIME, 2)
    object Animation : SerieCategory("Animación", SerieGenreId.ANIMATION)
    object Talk : SerieCategory("Shows de EE.UU", SerieGenreId.TALK)
}
