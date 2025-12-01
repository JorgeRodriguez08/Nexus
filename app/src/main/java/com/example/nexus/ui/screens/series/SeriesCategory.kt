package com.example.nexus.ui.screens.series

import com.example.nexus.data.remote.constants.NetworkConstants
import com.example.nexus.data.remote.constants.SeriesGenreIds

sealed class SeriesCategory(val title: String, val genreId: String? = null, val page: Int = 1, val originCountry: String = NetworkConstants.ORIGIN_COUNTRY_US) {
    object Trending : SeriesCategory("Las 10 series más populares hoy")
    object News : SeriesCategory("Lo nuevo en Nexus", SeriesGenreIds.NEWS)
    object Crime : SeriesCategory("Dramas implacables sobre crímenes", SeriesGenreIds.CRIME)
    object AiringToday : SeriesCategory("Para pasar el rato")
    object OnTheAir : SeriesCategory("Tu próxima historia")
    object Romantic : SeriesCategory("Series románticas", SeriesGenreIds.DRAMA)
    object RomanticAsiatic : SeriesCategory("Series románticas asiáticas", SeriesGenreIds.DRAMA, 1, NetworkConstants.ORIGINAL_COUNTRY_KR)
    object ActionAdventure : SeriesCategory("Series emocionantes", SeriesGenreIds.ACTION_ADVENTURE)
    object RomanticKorea : SeriesCategory("Series románticas coreanas", SeriesGenreIds.DRAMA, 2, NetworkConstants.ORIGINAL_COUNTRY_KR)
    object Family : SeriesCategory("Series para ver en familia", SeriesGenreIds.FAMILY)
    object Action : SeriesCategory("Series de Acción y Aventura", SeriesGenreIds.ACTION_ADVENTURE, 2)
    object Comedy : SeriesCategory("Series de Comedia", SeriesGenreIds.COMEDY)
    object Telenovela : SeriesCategory("Series románticas", SeriesGenreIds.DRAMA, 1,NetworkConstants.ORIGINAL_COUNTRY_MX)
    object Mystery : SeriesCategory("Series sombrías", SeriesGenreIds.MYSTERY)
    object SeriesKr : SeriesCategory("Series coreanas", SeriesGenreIds.MYSTERY, 1, NetworkConstants.ORIGINAL_COUNTRY_KR)
    object SciFiFantasy : SeriesCategory("Nuestra selección de hoy para ti", SeriesGenreIds.SCI_FI_FANTASY)
    object SeriesUs : SeriesCategory("Series de EE.UU", SeriesGenreIds.ACTION_ADVENTURE)
    object SeriesLatam : SeriesCategory("Series lationamericanas", SeriesGenreIds.MYSTERY,1, NetworkConstants.ORIGINAL_COUNTRY_MX)
    object Kids : SeriesCategory("Para ver con peques no tan peques", SeriesGenreIds.KIDS)
    object SeriesMex : SeriesCategory("Series mexicanas", SeriesGenreIds.DRAMA, 1, NetworkConstants.ORIGINAL_COUNTRY_MX)
    object Thriller : SeriesCategory("Para aniquilar el aburrimiento", SeriesGenreIds.CRIME, 2)
    object Popular : SeriesCategory("Series aclamadas por la crítica")
    object RomanticInter : SeriesCategory("Series internacionales románticas", SeriesGenreIds.DRAMA, 3, NetworkConstants.ORIGINAL_COUNTRY_KR)
    object War : SeriesCategory("Para aniquilar el aburrimiento", SeriesGenreIds.WAR_POLITICS)
    object Dark : SeriesCategory("Series dramáticas sombrías de EE.UU", SeriesGenreIds.CRIME, 2)
    object Animation : SeriesCategory("Animación", SeriesGenreIds.ANIMATION)
    object Talk : SeriesCategory("Shows de EE.UU", SeriesGenreIds.TALK)
}
