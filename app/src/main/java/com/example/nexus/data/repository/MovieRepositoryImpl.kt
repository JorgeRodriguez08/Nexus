package com.example.nexus.data.repository

import com.example.nexus.data.remote.mappers.toDomainMovie
import com.example.nexus.data.remote.ApiService
import com.example.nexus.domain.model.Movie
import com.example.nexus.domain.repository.MovieRepository
import com.example.nexus.common.Resource
import com.example.nexus.common.safeApiCall
import kotlinx.coroutines.flow.Flow

class MovieRepositoryImpl(private val apiService: ApiService) : MovieRepository {

    override fun getMoviesNowPlaying(page: Int): Flow<Resource<List<Movie>>> =
        safeApiCall  {
            apiService.getMoviesNowPlaying(page = page).results.map { it.toDomainMovie() }
        }

    override fun getMoviesPopular(page: Int): Flow<Resource<List<Movie>>> =
        safeApiCall {
            apiService.getMoviesPopular(page = page).results.map { it.toDomainMovie() }
        }

    override fun getMoviesTopRated(page: Int): Flow<Resource<List<Movie>>> =
        safeApiCall {
            apiService.getMoviesTopRated(page = page).results.map { it.toDomainMovie() }
        }

    override fun getMoviesUpComing(page: Int): Flow<Resource<List<Movie>>> =
        safeApiCall {
            apiService.getMoviesUpComing(page = page).results.map { it.toDomainMovie() }
        }

    override fun getMoviesByGenre(genreId: Int, page: Int): Flow<Resource<List<Movie>>> =
        safeApiCall {
            apiService.getMoviesByGenre(genreId = genreId, page = page).results.map { it.toDomainMovie()}
        }

    override fun getMovieById(movieId: Int): Flow<Resource<Movie>> =
        safeApiCall {
            apiService.getMovieById(movieId = movieId).toDomainMovie()
        }

    override fun searchMovies(query: String, page: Int): Flow<Resource<List<Movie>>> =
        safeApiCall {
            apiService.searchMovies(query = query, page = page).results.map { it.toDomainMovie() }
        }

}