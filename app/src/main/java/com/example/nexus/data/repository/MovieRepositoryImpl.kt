package com.example.nexus.data.repository

import coil.network.HttpException
import com.example.nexus.common.Resource
import com.example.nexus.common.safeApiCall
import com.example.nexus.data.remote.ApiService
import com.example.nexus.data.remote.mappers.toDomainActor
import com.example.nexus.data.remote.mappers.toDomainMovie
import com.example.nexus.data.remote.mappers.toDomainProducer
import com.example.nexus.data.remote.mappers.toDomainVideo
import com.example.nexus.domain.model.Actor
import com.example.nexus.domain.model.Movie
import com.example.nexus.domain.model.Producer
import com.example.nexus.domain.model.Video
import com.example.nexus.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

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

    override fun getMovieVideos(movieId: Int): Flow<Resource<Video>> = flow {
        emit(Resource.Loading)
        try {
            val response = apiService.getMovieVideos(movieId = movieId)
            val video = response.results
                .firstOrNull { it.site == "YouTube" && it.official == true }
                ?.toDomainVideo()
            if (video != null) {
                emit(Resource.Success(video))
            } else {
                emit(Resource.Error("No official trailer available for this movie."))
            }

        } catch (e: HttpException) {
            emit(Resource.Error("Unable to fetch movie videos due to a server error. Please try again later."))
        } catch (e: IOException) {
            emit(Resource.Error("Network error occurred. Please check your internet connection and try again."))
        }
    }

    override fun searchMovies(query: String, page: Int): Flow<Resource<List<Movie>>> =
        safeApiCall {
            apiService.searchMovies(query = query, page = page).results.map { it.toDomainMovie() }
        }

    override fun getMovieCast(movieId: Int): Flow<Resource<List<Actor>>> =
        safeApiCall {
            apiService.getMovieCredits(movieId = movieId).cast.map { it.toDomainActor() }
        }

    override fun getMovieCrew(movieId: Int): Flow<Resource<List<Producer>>> =
        safeApiCall {
            apiService.getMovieCredits(movieId = movieId).crew.map { it.toDomainProducer()}
        }

}