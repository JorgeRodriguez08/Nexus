package com.example.nexus.ui.screens.movies

import com.example.nexus.data.remote.constants.MoviesGenreIds
import com.example.nexus.data.remote.constants.NetworkConstants

sealed class MoviesCategory(val title: String, val genreId: String? = null, val page: Int = 1, val originalCountry: String = NetworkConstants.ORIGIN_COUNTRY_US) {

    object UpComing : MoviesCategory("Creemos que estos te encantarán")
    object Thriller : MoviesCategory("De intriga", MoviesGenreIds.THRILLER, 1)
    object NewHistory : MoviesCategory("Tu próxima historia", MoviesGenreIds.ACTION, 1)
    object Family : MoviesCategory("Películas para toda la Familia", MoviesGenreIds.FAMILY)
    object ActionAndDrama : MoviesCategory("Cine de intriga y acción", MoviesGenreIds.ACTION + NetworkConstants.AND + MoviesGenreIds.DRAMA, 2)
    object ActionComedy : MoviesCategory("Películas de acción para reír", MoviesGenreIds.ACTION + NetworkConstants.AND + MoviesGenreIds.COMEDY, 1)
    object OnlyNexus : MoviesCategory("Solo en Nexus", MoviesGenreIds.ADVENTURE + NetworkConstants.AND + MoviesGenreIds.DRAMA)
    object NowPlaying : MoviesCategory("Lo nuevo en Nexus")
    object Comedy : MoviesCategory("Películas disparatadas para reír", MoviesGenreIds.COMEDY, 2)
    object Action : MoviesCategory("Películas de acción de Hollywood", MoviesGenreIds.ACTION, 2)
    object ActionAndThriller : MoviesCategory("Películas de acción y aventura de suspenso", MoviesGenreIds.ACTION + NetworkConstants.AND + MoviesGenreIds.ADVENTURE + NetworkConstants.AND + MoviesGenreIds.THRILLER)
    object Drama : MoviesCategory("Cine dramático de Hollywood", MoviesGenreIds.DRAMA)
    object DramaAndDocumentary : MoviesCategory("Cine dramático basado en hechos reales", MoviesGenreIds.DRAMA + NetworkConstants.AND + MoviesGenreIds.DOCUMENTARY)
    object Terror : MoviesCategory("Noches de pelis con amigos", MoviesGenreIds.HORROR, 1)
    object SciFiAndFantasy : MoviesCategory("Peliculones de sci-fi y fantasía", MoviesGenreIds.SCIENCE_FICTION + NetworkConstants.AND + MoviesGenreIds.FANTASY )
    object Thriller2 : MoviesCategory("Películas de suspenso", MoviesGenreIds.THRILLER, 2)
    object ScienceFiction : MoviesCategory("Peliculones de la década de 2020", MoviesGenreIds.SCIENCE_FICTION, 1)
    object Crime : MoviesCategory("Películas sobre crímenes", MoviesGenreIds.CRIME)
    object TvMovie : MoviesCategory("De Hollywood a tu pantalla", MoviesGenreIds.TV_MOVIE)
    object WarAndThriller : MoviesCategory("Cine de intriga y acción de suspenso", MoviesGenreIds.THRILLER + NetworkConstants.AND + MoviesGenreIds.WAR)
    object DramaArgentina : MoviesCategory("Películas argentinas", MoviesGenreIds.DRAMA, 1,
        NetworkConstants.ORIGINAL_COUNTRY_AR
    )
    object Comedy2 : MoviesCategory("Películas para reír", MoviesGenreIds.COMEDY, 3)
    object Horror : MoviesCategory("Noches de pelis con amigos", MoviesGenreIds.HORROR, 2)
    object ActionKorea : MoviesCategory("Películas y programas de Asia", MoviesGenreIds.ACTION + NetworkConstants.AND + MoviesGenreIds.DRAMA, 1,
        NetworkConstants.ORIGINAL_COUNTRY_KR
    )
    object Animation : MoviesCategory("Noches de pelis con amigos", MoviesGenreIds.ANIMATION)
    object Drama2 : MoviesCategory("Cine dramático", MoviesGenreIds.DRAMA, 2)
    object ActionAndSciFi : MoviesCategory("Acción  y sci-fi", MoviesGenreIds.ACTION + NetworkConstants.AND + MoviesGenreIds.SCIENCE_FICTION)
    object TaqAction : MoviesCategory("Taquillazos emocionantes", MoviesGenreIds.ACTION, 3)
    object Romance : MoviesCategory("Cine romántico", MoviesGenreIds.ROMANCE)
    object Trending : MoviesCategory("Las 10 películas más populares hoy")
    object Popular : MoviesCategory("Favoritos de ayer y hoy")
    object War : MoviesCategory("Películas de acción militar", MoviesGenreIds.WAR)
    object Mystery : MoviesCategory("Cine de intriga que hiela la sangre", MoviesGenreIds.MYSTERY)
    object Adventure : MoviesCategory("Películas de acción y aventura", MoviesGenreIds.ADVENTURE)
    object Fantasy : MoviesCategory("Modo todoterreno activado", MoviesGenreIds.FANTASY)
    object Western : MoviesCategory("Películas de Occidente", MoviesGenreIds.WESTERN)
}