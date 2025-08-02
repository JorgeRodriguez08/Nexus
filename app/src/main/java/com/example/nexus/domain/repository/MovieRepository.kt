package com.example.nexus.domain.repository

import com.example.nexus.domain.model.Movie
import com.example.nexus.common.Resource
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    fun getMoviesNowPlaying(page: Int): Flow<Resource<List<Movie>>>

    fun getMoviesPopular(page: Int): Flow<Resource<List<Movie>>>

    fun getMoviesTopRated(page: Int): Flow<Resource<List<Movie>>>

    fun getMoviesUpComing(page: Int): Flow<Resource<List<Movie>>>

    fun getMoviesByGenre(genreId: Int, page: Int): Flow<Resource<List<Movie>>>

    fun getMovieById(movieId: Int): Flow<Resource<Movie>>

    fun searchMovies(query: String, page: Int): Flow<Resource<List<Movie>>>

}

