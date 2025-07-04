package com.example.nexus.ui.samples

import com.example.nexus.domain.model.Movie
import kotlin.reflect.typeOf

object Samples {
    val movie = Movie(1, "Inception", "Overview 1", "https://image.tmdb.org/t/p/original/rJLvP1mQfUu9S2Zt4c2f7P0M2w.jpg", "", 8.8, "2010-07-16")

    val movies = listOf(
        Movie(1, "Inception", "Overview 1", "https://image.tmdb.org/t/p/original/rJLvP1mQfUu9S2Zt4c2f7P0M2w.jpg", "", 8.8, "2010-07-16"),
        Movie(2, "The Matrix", "Overview 2", "https://image.tmdb.org/t/p/original/f89U3ADr1rbDPmWnyNlkzM5Xyem.jpg", "", 8.7, "1999-03-31"),
        Movie(3, "Interstellar", "Overview 3", "https://image.tmdb.org/t/p/original/gEU2QjluzxSwzSJWb_k2P9fLp8.jpg", "", 8.6, "2014-11-05"),
        Movie(4, "Pulp Fiction", "Overview 4", "https://image.tmdb.org/t/p/original/d5iFMwjk2o0mJmS1w02g0gN8o4.jpg", "", 8.9, "1994-10-14"),
        Movie(5, "Fight Club", "Overview 5", "https://image.tmdb.org/t/p/original/a2o0xQh0j1M5f3d3G9t0h0L0w0.jpg", "", 8.5, "1999-10-15"),
        Movie(6, "Forrest Gump", "Overview 6", "https://image.tmdb.org/t/p/original/arw2FuxgpmLolEgJ4pfN6aqtJ0G.jpg", "", 8.8, "1994-07-06")
    )

    data class Section(
        val title: String,
        val id: Int
    )

    val categories = listOf(
        Section(title = "Principal", id = 1),
        Section(title = "Juegos Moviles", id = 1),
        Section(title = "Los 10 juegos móviles más populares", id = 2),
        Section(title = "Creemos que estos te encantarán", id = 3),
        Section(title = "Nuestra selección de hoy para ti", id = 4),
        Section(title = "Solo en Netxus", id = 5),
        Section(title = "Serie de EE.UU ", id = 6),
        Section(title = "Lo nuevo en Nexus", id = 7),
        Section(title = "Las 10 series más populares en Argentina hoy", id = 8),
        Section(title = "Series dramáticas coreanas", id = 8),
        Section(title = "Atrapantes de principio a fin", id = 8),
        Section(title = "Series románticas coreanas", id = 8),
        Section(title = "Las 10 películas más populares en Argentina hoy", id = 8),
        Section(title = "Series dramáticas", id = 8),
        Section(title = "Series de EE.UU.", id = 8),
        Section(title = "Planes a largo plazo", id = 8),
        Section(title = "Series sobre crímenes", id = 8),
        Section(title = "Animes", id = 8),
        Section(title = "Películas y series en español", id = 8),
        Section(title = "Películas y programas de Asia", id = 8),
        Section(title = "Películas de Holliwood dobladas al español", id = 8),
        Section(title = "WWE: En vivo y próximos", id = 8),
        Section(title = "Telenovelas", id = 8),
        Section(title = "De Hollywood a tu pantalla", id = 8),
        Section(title = "Series para maratonear", id = 8),
        Section(title = "Las 10 series más populares en Argentina hoy", id = 8),
        Section(title = "Películas de accion y aventura", id = 8),
        Section(title = "Favoritas del público", id = 8),
        Section(title = "Series románticas", id = 8),
        Section(title = "Series aclamadas por la crítica", id = 8),
        Section(title = "Película de terror", id = 8),
        Section(title = "Series drámaticas aclamadas por la crítica", id = 8)
    )
}