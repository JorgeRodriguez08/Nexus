package com.example.nexus.ui.screens.movies

import com.example.nexus.constants.MovieGenreId
import com.example.nexus.constants.NetworkConstants

sealed class MovieCategory(val title: String, val genreId: String? = null, val page: Int = 1, val originCountry: String = NetworkConstants.ORIGIN_COUNTRY_US) {
    object UpComing : MovieCategory("Creemos que estos te encantarán")
    object Thriller : MovieCategory("De intriga", MovieGenreId.THRILLER, 1)
    object NewHistory : MovieCategory("Tu próxima historia", MovieGenreId.ACTION, 1)
    object Family : MovieCategory("Películas para toda la Familia", MovieGenreId.FAMILY)
    object ActionAndDrama : MovieCategory("Cine de intriga y acción", MovieGenreId.ACTION + NetworkConstants.AND + MovieGenreId.DRAMA, 2)
    object ActionComedy : MovieCategory("Películas de acción para reír", MovieGenreId.ACTION + NetworkConstants.AND + MovieGenreId.COMEDY, 1)
    object OnlyNexus : MovieCategory("Solo en Nexus", MovieGenreId.ADVENTURE + NetworkConstants.AND + MovieGenreId.DRAMA)
    object NowPlaying : MovieCategory("Lo nuevo en Nexus")
    object Comedy : MovieCategory("Películas disparatadas para reír", MovieGenreId.COMEDY, 2)
    object Action : MovieCategory("Películas de acción de Hollywood", MovieGenreId.ACTION, 2)
    object ActionAndThriller : MovieCategory("Películas de acción y aventura de suspenso", MovieGenreId.ACTION + NetworkConstants.AND + MovieGenreId.ADVENTURE + NetworkConstants.AND + MovieGenreId.THRILLER)
    object Drama : MovieCategory("Cine dramático de Hollywood", MovieGenreId.DRAMA)
    object DramaAndDocumentary : MovieCategory("Cine dramático basado en hechos reales", MovieGenreId.DRAMA + NetworkConstants.AND + MovieGenreId.DOCUMENTARY)
    object Terror : MovieCategory("Noches de pelis con amigos", MovieGenreId.HORROR, 1)
    object SciFiAndFantasy : MovieCategory("Peliculones de sci-fi y fantasía", MovieGenreId.SCIENCE_FICTION + NetworkConstants.AND + MovieGenreId.FANTASY )
    object Thriller2 : MovieCategory("Películas de suspenso", MovieGenreId.THRILLER, 2)
    object ScienceFiction : MovieCategory("Peliculones de la década de 2020", MovieGenreId.SCIENCE_FICTION, 1)
    object Crime : MovieCategory("Películas sobre crímenes", MovieGenreId.CRIME)
    object TvMovie : MovieCategory("De Hollywood a tu pantalla", MovieGenreId.TV_MOVIE)
    object WarAndThriller : MovieCategory("Cine de intriga y acción de suspenso", MovieGenreId.THRILLER + NetworkConstants.AND + MovieGenreId.WAR)
    object DramaArgentina : MovieCategory("Películas argentinas", MovieGenreId.DRAMA, 1,
        NetworkConstants.ORIGINAL_COUNTRY_AR
    )
    object Comedy2 : MovieCategory("Películas para reír", MovieGenreId.COMEDY, 3)
    object Horror : MovieCategory("Noches de pelis con amigos", MovieGenreId.HORROR, 2)
    object ActionKorea : MovieCategory("Películas y programas de Asia", MovieGenreId.ACTION + NetworkConstants.AND + MovieGenreId.DRAMA, 1,
        NetworkConstants.ORIGINAL_COUNTRY_KR
    )
    object Animation : MovieCategory("Noches de pelis con amigos", MovieGenreId.ANIMATION)
    object Drama2 : MovieCategory("Cine dramático", MovieGenreId.DRAMA, 2)
    object ActionAndSciFi : MovieCategory("Acción  y sci-fi", MovieGenreId.ACTION + NetworkConstants.AND + MovieGenreId.SCIENCE_FICTION)
    object TaqAction : MovieCategory("Taquillazos emocionantes", MovieGenreId.ACTION, 3)
    object Romance : MovieCategory("Cine romántico", MovieGenreId.ROMANCE)
    object Trending : MovieCategory("Las 10 películas más populares hoy")
    object Popular : MovieCategory("Favoritos de ayer y hoy")
    object War : MovieCategory("Películas de acción militar", MovieGenreId.WAR)
    object Mystery : MovieCategory("Cine de intriga que hiela la sangre", MovieGenreId.MYSTERY)
    object Adventure : MovieCategory("Películas de acción y aventura", MovieGenreId.ADVENTURE)
    object Fantasy : MovieCategory("Modo todoterreno activado", MovieGenreId.FANTASY)
    object Western : MovieCategory("Películas de Occidente", MovieGenreId.WESTERN)
}