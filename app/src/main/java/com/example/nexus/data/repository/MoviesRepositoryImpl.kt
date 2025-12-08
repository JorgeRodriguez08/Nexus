package com.example.nexus.data.repository

import com.example.nexus.common.Resource
import com.example.nexus.common.safeApiCall
import com.example.nexus.constants.ErrorMessages
import com.example.nexus.data.remote.ApiService
import com.example.nexus.data.remote.mappers.toDomainActor
import com.example.nexus.data.remote.mappers.toDomainImageMovie
import com.example.nexus.data.remote.mappers.toDomainMovie
import com.example.nexus.data.remote.mappers.toDomainProducer
import com.example.nexus.domain.models.ImageMovie
import com.example.nexus.domain.models.Movie
import com.example.nexus.domain.models.MovieDetails
import com.example.nexus.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class MoviesRepositoryImpl(private val apiService: ApiService) : MoviesRepository {
    override fun getMoviesTrending(): Flow<Resource<List<Movie>>> =
        safeApiCall {
            apiService.getMoviesTrending().results.map { it.toDomainMovie() }
        }

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

    override fun discoverMovies(genreId: String, page: Int, originCountry: String): Flow<Resource<List<Movie>>> =
        safeApiCall {
            apiService.discoverMovies(genreId = genreId, page = page, originCountry = originCountry).results.map { it.toDomainMovie()}
        }

    override fun searchMovie(query: String, page: Int): Flow<Resource<List<Movie>>> =
        safeApiCall {
            apiService.searchMovie(query = query, page = page).results.map { it.toDomainMovie() }
        }

    override fun getMovieDetails(movieId: Int): Flow<Resource<MovieDetails>> = flow {
        emit(Resource.Loading)
        try {
            val movieResponse = apiService.getMovieDetails(movieId)
            val creditsResponse = apiService.getMovieCredits(movieId)
            val imagesMovieResponse = apiService.getMovieImages(movieId)

            val movie = movieResponse.toDomainMovie()
            val cast = creditsResponse.cast.map { it.toDomainActor() }
            val crew = creditsResponse.crew.map { it.toDomainProducer() }
            val imageMovie = imagesMovieResponse.logos.first().toDomainImageMovie()

            val movieDetails = MovieDetails(
                movie = movie,
                cast = cast,
                crew = crew,
                imageMovie = imageMovie
            )
            emit(Resource.Success(movieDetails))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: ErrorMessages.HTTP))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: ErrorMessages.NETWORK))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: ErrorMessages.UNKNOWN))
        }
    }

    override fun getMovieImage(movieId: Int): Flow<Resource<ImageMovie>> = flow {
        emit(Resource.Loading)
        try {
            val imagesMovieResponse = apiService.getMovieImages(movieId)
            var imageMovie = imagesMovieResponse.logos.first().toDomainImageMovie()
            emit(Resource.Success(imageMovie))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: ErrorMessages.HTTP))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: ErrorMessages.NETWORK))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: ErrorMessages.UNKNOWN))
        }
    }
}