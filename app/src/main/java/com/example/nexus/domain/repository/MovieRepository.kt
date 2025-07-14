package com.example.nexus.domain.repository

import com.example.nexus.domain.model.Movie
import com.example.nexus.utils.Resource
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    fun getMovies(page: Int): Flow<Resource<List<Movie>>>

    fun getMovieById(movieId: Int): Flow<Resource<Movie>>

    fun searchMovies(query: String, page: Int): Flow<Resource<List<Movie>>>

    fun getMovieByGenre(genreId: Int, language: String?, page: Int): Flow<Resource<List<Movie>>>

}

