package com.example.nexus.domain.repository

import com.example.nexus.domain.model.Movie
import com.example.nexus.utils.Resource

interface MovieRepository {

    suspend fun getPopularMovies(page: Int): Resource<List<Movie>>

    suspend fun getMovieDetails(movieId: Int): Resource<Movie>

    suspend fun searchMovies(query: String, page: Int): Resource<List<Movie>>

}