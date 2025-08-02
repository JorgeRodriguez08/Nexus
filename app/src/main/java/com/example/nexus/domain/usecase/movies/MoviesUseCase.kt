package com.example.nexus.domain.usecase.movies

data class MoviesUseCase(
    val getMoviesNowPlaying: GetMoviesNowPlayingUseCase,
    val getMoviesTopRated: GetMoviesTopRatedUseCase,
    val getMoviesPopular: GetMoviesPopularUseCase,
    val getMoviesUpComing: GetMoviesUpComingUseCase,
    val getMoviesByGenre: GetMoviesByGenreUseCase,
    val getMovieById: GetMovieByIdUseCase,
    val searchMovies: SearchMoviesUseCase
)
