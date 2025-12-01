package com.example.nexus.domain.repository

import com.example.nexus.common.Resource
import com.example.nexus.domain.model.Actor
import com.example.nexus.domain.model.ImageMovie
import com.example.nexus.domain.model.Movie
import com.example.nexus.domain.model.MovieDetail
import com.example.nexus.domain.model.MovieMultimedia
import com.example.nexus.domain.model.Producer
import com.example.nexus.domain.model.VideoMovie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getMoviesTrending(): Flow<Resource<List<Movie>>>

    fun getMoviesNowPlaying(page: Int): Flow<Resource<List<Movie>>>

    fun getMoviesPopular(page: Int): Flow<Resource<List<Movie>>>

    fun getMoviesTopRated(page: Int): Flow<Resource<List<Movie>>>

    fun getMoviesUpComing(page: Int): Flow<Resource<List<Movie>>>

    fun discoverMovies(genreId: String, page: Int): Flow<Resource<List<Movie>>>

    fun searchMovie(query: String, page: Int): Flow<Resource<List<Movie>>>

    fun getMovieDetails(movieId: Int): Flow<Resource<Movie>>

    fun getMovieImages(movieId: Int): Flow<Resource<ImageMovie?>>

    fun getMovieVideos(movieId: Int): Flow<Resource<VideoMovie?>>

    fun getMovieCast(movieId: Int): Flow<Resource<List<Actor>>>

    fun getMovieCrew(movieId: Int): Flow<Resource<List<Producer>>>

    fun getMovieIntegrate(movieId: Int): Flow<Resource<MovieDetail>>

    fun getMovieMultimedia(movieId: Int): Flow<Resource<MovieMultimedia>>
}

