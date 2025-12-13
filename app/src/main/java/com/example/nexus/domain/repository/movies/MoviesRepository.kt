package com.example.nexus.domain.repository.movies

import com.example.nexus.common.core.Resource
import com.example.nexus.domain.model.ImageMovie
import com.example.nexus.domain.model.Movie
import com.example.nexus.domain.model.MovieDetails
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    fun getMoviesTrending(): Flow<Resource<List<Movie>>>
    fun getMoviesNowPlaying(page: Int): Flow<Resource<List<Movie>>>
    fun getMoviesPopular(page: Int): Flow<Resource<List<Movie>>>
    fun getMoviesTopRated(page: Int): Flow<Resource<List<Movie>>>
    fun getMoviesUpComing(page: Int): Flow<Resource<List<Movie>>>
    fun discoverMovies(genreId: String, page: Int, originCountry: String): Flow<Resource<List<Movie>>>
    fun searchMovie(query: String, page: Int): Flow<Resource<List<Movie>>>
    fun getMovieDetails(movieId: Int): Flow<Resource<MovieDetails>>
    fun getMovieImage(movieId: Int): Flow<Resource<ImageMovie?>>
}