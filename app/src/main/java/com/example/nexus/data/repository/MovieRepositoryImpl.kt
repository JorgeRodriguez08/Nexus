package com.example.nexus.data.repository

import com.example.nexus.data.mappers.toDomainMovie
import com.example.nexus.data.remote.ApiService
import com.example.nexus.domain.model.Movie
import com.example.nexus.domain.repository.MovieRepository
import com.example.nexus.utils.ErrorMessages
import com.example.nexus.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class MovieRepositoryImpl(private val apiService: ApiService) : MovieRepository {

    override fun getMovies(page: Int): Flow<Resource<List<Movie>>> = flow {
        emit(Resource.Loading())
        try {
            val response = apiService.getMovies(page = page)
            val domainMovies = response.results.map { it.toDomainMovie() }
            if (domainMovies.isNotEmpty()) {
                emit(Resource.Success(domainMovies))
            } else {
                emit(Resource.Error(ErrorMessages.NO_POPULAR_MOVIES))
            }
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: ErrorMessages.HTTP))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: ErrorMessages.NETWORK))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: ErrorMessages.UNKNOWN))
        }
    }

    override fun getMovieById(movieId: Int): Flow<Resource<Movie>> = flow {
        emit(Resource.Loading())
        try {
            val response = apiService.getMovieById(movieId = movieId)
            emit(Resource.Success(response.toDomainMovie()))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: ErrorMessages.HTTP))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: ErrorMessages.NETWORK))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: ErrorMessages.UNKNOWN))
        }
    }

    override fun searchMovies(query: String, page: Int): Flow<Resource<List<Movie>>> = flow {
        emit(Resource.Loading())
        try {
            val response = apiService.searchMovies(query = query, page = page)
            val domainMovies = response.results.map { it.toDomainMovie() }
            if (domainMovies.isNotEmpty()) {
                emit(Resource.Success(domainMovies))
            } else {
                emit(Resource.Error(ErrorMessages.NO_POPULAR_MOVIES))
            }
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: ErrorMessages.HTTP))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: ErrorMessages.NETWORK))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: ErrorMessages.UNKNOWN))
        }
    }

    override fun getMovieByGenre(genreId: Int, language: String?, page: Int): Flow<Resource<List<Movie>>> = flow {
        emit(Resource.Loading())
        try {
            val response = apiService.getMoviesByGenre(genreId = genreId, language = language, page = page)
            val movies = response.results.map { it.toDomainMovie() }
            emit(Resource.Success(movies))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: ErrorMessages.HTTP))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: ErrorMessages.NETWORK))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: ErrorMessages.UNKNOWN))
        }
    }
}