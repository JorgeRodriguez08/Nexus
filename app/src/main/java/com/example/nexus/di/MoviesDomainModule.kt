package com.example.nexus.di

import com.example.nexus.domain.usecase.movies.GetMovieDetailsUseCase
import com.example.nexus.domain.usecase.movies.GetMovieCastUseCase
import com.example.nexus.domain.usecase.movies.GetMovieCrewUseCase
import com.example.nexus.domain.usecase.movies.GetMovieIntegrateUseCase
import com.example.nexus.domain.usecase.movies.GetMovieMultimediaUseCase
import com.example.nexus.domain.usecase.movies.GetMovieVideosUseCase
import com.example.nexus.domain.usecase.movies.DiscoverMoviesUseCase
import com.example.nexus.domain.usecase.movies.GetMoviesNowPlayingUseCase
import com.example.nexus.domain.usecase.movies.GetMoviesPopularUseCase
import com.example.nexus.domain.usecase.movies.GetMoviesTopRatedUseCase
import com.example.nexus.domain.usecase.movies.GetMoviesTrendingUseCase
import com.example.nexus.domain.usecase.movies.GetMoviesUpComingUseCase
import com.example.nexus.domain.usecase.movies.MoviesUseCase
import com.example.nexus.domain.usecase.movies.SearchMovieUseCase
import org.koin.dsl.module

val moviesDomainModule = module {
    factory { GetMoviesTrendingUseCase(get()) }
    factory { GetMoviesNowPlayingUseCase(get()) }
    factory { GetMoviesPopularUseCase(get()) }
    factory { GetMoviesTopRatedUseCase(get()) }
    factory { GetMoviesUpComingUseCase(get()) }
    factory { DiscoverMoviesUseCase(get()) }
    factory { SearchMovieUseCase(get()) }
    factory { GetMovieDetailsUseCase(get()) }
    factory { GetMovieVideosUseCase(get()) }
    factory { GetMovieCastUseCase(get()) }
    factory { GetMovieCrewUseCase(get()) }
    factory { GetMovieIntegrateUseCase(get())}
    factory { GetMovieMultimediaUseCase(get())}

    factory {
        MoviesUseCase(
            getMoviesTrending = get(),
            getMoviesNowPlaying = get(),
            getMoviesPopular = get(),
            getMoviesTopRated = get(),
            getMoviesUpComing = get(),
            discoverMovies = get(),
            searchMovie = get(),
            getMovieDetails = get(),
            getMovieVideos = get(),
            getMovieCast = get(),
            getMovieCrew = get(),
            getMovieIntegrate = get(),
            getMovieMultimedia = get()
        )
    }
}