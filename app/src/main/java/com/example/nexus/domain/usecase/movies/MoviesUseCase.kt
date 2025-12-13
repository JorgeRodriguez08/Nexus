package com.example.nexus.domain.usecase.movies

data class MoviesUseCase(
    val getMoviesTrending: GetMoviesTrendingUseCase,
    val getMoviesNowPlaying: GetMoviesNowPlayingUseCase,
    val getMoviesPopular: GetMoviesPopularUseCase,
    val getMoviesTopRated: GetMoviesTopRatedUseCase,
    val getMoviesUpComing: GetMoviesUpComingUseCase,
    val discoverMovies: DiscoverMoviesUseCase,
    val searchMovie: SearchMovieUseCase,
    val getMovieDetails: GetMovieDetailsUseCase,
    val getMovieImage: GetMovieImageUseCase
)
