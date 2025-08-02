package com.example.nexus.di

import com.example.nexus.domain.usecase.movies.GetMovieByIdUseCase
import com.example.nexus.domain.usecase.movies.GetMoviesByGenreUseCase
import com.example.nexus.domain.usecase.movies.GetMoviesNowPlayingUseCase
import com.example.nexus.domain.usecase.movies.GetMoviesPopularUseCase
import com.example.nexus.domain.usecase.movies.GetMoviesTopRatedUseCase
import com.example.nexus.domain.usecase.movies.GetMoviesUpComingUseCase
import com.example.nexus.domain.usecase.movies.MoviesUseCase
import com.example.nexus.domain.usecase.movies.SearchMoviesUseCase
import org.koin.dsl.module

val moviesDomainModule = module {

    factory { GetMoviesNowPlayingUseCase(get()) }
    factory { GetMoviesTopRatedUseCase(get()) }
    factory { GetMoviesPopularUseCase(get()) }
    factory { GetMoviesUpComingUseCase(get()) }
    factory { GetMoviesByGenreUseCase(get()) }
    factory { GetMovieByIdUseCase(get()) }
    factory { SearchMoviesUseCase(get()) }

    factory {
        MoviesUseCase(
            getMoviesNowPlaying = get(),
            getMoviesTopRated = get(),
            getMoviesPopular = get(),
            getMoviesUpComing = get(),
            getMoviesByGenre = get(),
            getMovieById = get(),
            searchMovies = get()
        )
    }

}