package com.example.nexus.ui.screen.home

import com.example.nexus.ui.screen.GenreIds

sealed class HomeCategory(
    val title: String,
    val genreId: Int? = null,
    val isMovie: Boolean = false,
    val isSeries: Boolean = false,
) {
    object ThrillingSeries : HomeCategory("Series de Suspenso para maratonear premiadas", genreId = GenreIds.THRILLER, isSeries = true)
    //object TodaySelection : HomeCategory("Nuestra selección de hoy para ti", isMovie = false)
    //object Top10SeriesArgentina : HomeCategory("Las 10 series más populares en Argentina hoy", isMovie = false)
    //object OnlyOnNetflix : HomeCategory("Solo en Nexus", isMovie = false)
    //object SpanishContent : HomeCategory("Películas y series en español")
    object AllAction : HomeCategory("Toda la acción", genreId = GenreIds.ACTION, isMovie = true)
    //object NewReleases : HomeCategory("Lo nuevo en Nexus")
    object RomanticSeries : HomeCategory("Series Románticas", genreId = GenreIds.ROMANCE, isSeries = true)
    //object DubbedHollywood : HomeCategory("Películas de Hollywood dobladas al español", isMovie = true)
    //object Top10MoviesArgentina : HomeCategory("Las 10 películas más populares en Argentina hoy")
    object NextStory : HomeCategory("Tu próxima historia", genreId = GenreIds.DOCUMENTARY, isSeries = true)
    object ActionAdventure : HomeCategory("Películas de acción y aventura", genreId = GenreIds.ADVENTURE, isMovie = true)
    object TeenSeries : HomeCategory("Series de adolescentes sobre la transición a la edad adulta", genreId = GenreIds.FAMILY, isSeries = true)
    object EmotionalDramas : HomeCategory("Series dramáticas emotivas", genreId = GenreIds.DRAMA, isSeries = true)
    //object USASeries : HomeCategory("Series de EE. UU.")
    object ActionHeroes : HomeCategory("Héroes de acción", genreId = GenreIds.FANTASY, isMovie = true)
    //object MarathonSeries : HomeCategory("Series para maratonear")
    object UnforgettableRomance : HomeCategory("Romances Inolvidables", genreId = GenreIds.ROMANCE, isMovie = true)
    object HorrorMovies : HomeCategory("Películas de terror", genreId = GenreIds.HORROR, isMovie = true)
    object RecommendedForYou : HomeCategory("Creemos que estos te encantarán", genreId = GenreIds.SCIENCE_FICTION, isSeries = true)
    //object AsianRomanticSeries : HomeCategory("Series asiáticas románticas", genreId = GenreIds.ROMANCE, isSeries = true)
    object HeartfeltContent : HomeCategory("Directo al corazón", genreId = GenreIds.WAR, isSeries = true)
    //object FamilyFriendly : HomeCategory("Para ver con peques no tan peques", genreId = GenreIds.ANIMATION)
    //object LongTermPlans : HomeCategory("Planes a largo plazo")
    //object TrendingNow : HomeCategory("Los más buscados")
    object AddictiveContent : HomeCategory("Atrapantes de principio a fin", genreId = GenreIds.MYSTERY, isMovie = true)
    object RevengeSeries : HomeCategory("Series de venganza", genreId = GenreIds.CRIME, isSeries = true)
    //object BlockbusterMovies : HomeCategory("Películas taquilleras")
    object ComedyMovies : HomeCategory("Películas para reír", genreId = GenreIds.COMEDY, isMovie = true)
    object DarkSeries : HomeCategory("Series sombrías", genreId = GenreIds.MYSTERY, isSeries = true)
    object KidsMovies : HomeCategory("Películas infantiles", genreId = GenreIds.KIDS, isMovie = true )
    object DramaSeries : HomeCategory("Series Dramáticas", genreId = GenreIds.DRAMA, isSeries = true)
    object SciFiHorrorSeries : HomeCategory("Series de sci-fi y terror", genreId = GenreIds.SCIENCE_FICTION, isSeries = true)
    object HollywoodOnYourScreen : HomeCategory("De hollywood a tu pantalla", genreId = GenreIds.TV_MOVIE, isMovie = true)
}
