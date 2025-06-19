package com.example.nexus.data.repository

import com.example.nexus.data.remote.ApiService
import com.example.nexus.data.mappers.toDomainMovie
import com.example.nexus.domain.model.Movie
import com.example.nexus.domain.repository.MovieRepository
import com.example.nexus.untils.Resource
import retrofit2.HttpException
import java.io.IOException

class MovieRepositoryImpl(
    private val apiService: ApiService
) : MovieRepository {
    override suspend fun getPopularMovies(page: Int): Resource<List<Movie>> {
        return try {
            val response = apiService.getPopularMovies(page = page)
            if (response.results.isNotEmpty()) {
                val domainMovies = response.results.map { it.toDomainMovie() }
                Resource.Success(domainMovies)
            } else {
                Resource.Error("No popular movies found.")
            }
        } catch (e: HttpException) {
            // HTTP error (e.g., 404, 500)
            Resource.Error(e.localizedMessage ?: "An unexpected networking error occurred")
        } catch (e: IOException) {
            // Network error (no internet connection, DNS, etc.)
            Resource.Error("Could not connect to the server. Please check your internet connection.")
        } catch (e: Exception) {
            // Other generic errors
            Resource.Error(e.localizedMessage ?: "An unknown error occurred")
        }
    }

    override suspend fun getMovieDetails(movieId: Int): Resource<Movie> {
        return try {
            val response = apiService.getDetailsMovies(movieId = movieId)
            val domainMovieDetails = response.toDomainMovie()
            Resource.Success(domainMovieDetails)
        } catch (e: HttpException) {
            // HTTP error (e.g., 404, 500)
            Resource.Error(e.localizedMessage ?: "An unexpected networking error occurred")
        } catch (e: IOException) {
            // Network error (no internet connection, DNS, etc.)
            Resource.Error("Could not connect to the server. Please check your internet connection.")
        } catch (e: Exception) {
            // Other generic errors
            Resource.Error(e.localizedMessage ?: "An unknown error occurred")
        }
    }

    override suspend fun searchMovies(query: String, page: Int): Resource<List<Movie>> {
        return try {
            val response = apiService.searchMovie(query = query, page = page)
            if (!response.results.isNotEmpty()) {
                val domainMoviesFound = response.results.map { it.toDomainMovie()}
                Resource.Success(domainMoviesFound)
            } else {
                Resource.Error("No search movies found")
            }
        } catch (e: HttpException) {
            Resource.Error(e.localizedMessage ?: "An unexpected networking error occurred")
        } catch (e: IOException) {
            Resource.Error("Could not connect to the server. Please check your internet connection")
        } catch (e: Exception) {
            Resource.Error(e.localizedMessage ?: "An unknown error occurred")
        }
    }
}