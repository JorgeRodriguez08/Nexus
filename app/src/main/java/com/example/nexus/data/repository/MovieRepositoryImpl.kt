package com.example.nexus.data.repository

import com.example.nexus.common.Resource
import com.example.nexus.common.safeApiCall
import com.example.nexus.data.remote.ApiService
import com.example.nexus.data.remote.mappers.toDomainActor
import com.example.nexus.data.remote.mappers.toDomainImageMovie
import com.example.nexus.data.remote.mappers.toDomainMovie
import com.example.nexus.data.remote.mappers.toDomainProducer
import com.example.nexus.data.remote.mappers.toDomainVideoMovie
import com.example.nexus.domain.model.Actor
import com.example.nexus.domain.model.ImageMovie
import com.example.nexus.domain.model.Movie
import com.example.nexus.domain.model.MovieDetail
import com.example.nexus.domain.model.MovieMultimedia
import com.example.nexus.domain.model.Producer
import com.example.nexus.domain.model.VideoMovie
import com.example.nexus.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

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
            apiService.getMovieDetail(movieId = movieId).toDomainMovie()
        }

    override fun getMovieImages(movieId: Int): Flow<Resource<ImageMovie?>> = flow {
        emit(Resource.Loading)
        try {
            val response = apiService.getMovieImages(movieId)
            var image: ImageMovie? = null
            if (response.logos != null && response.logos.isNotEmpty()) {
                image = response.logos[0].toDomainImageMovie()
            }
            emit(Resource.Success(image))
        } catch (e: Exception) {
            emit(Resource.Error("Error loading images"))
        }
    }

    override fun getMovieVideos(movieId: Int): Flow<Resource<VideoMovie?>> = flow {
        emit(Resource.Loading)
        try {
            val response = apiService.getMovieVideos(movieId)
            var video: VideoMovie? = null
            if (response.results != null && response.results.isNotEmpty()) {
                video = response.results[0].toDomainVideoMovie()
            }
            emit(Resource.Success(video))
        } catch (e: Exception) {
            emit(Resource.Error("Error loading videos"))
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

    override fun getMovieDetail(movieId: Int): Flow<Resource<MovieDetail>> = flow {
        emit(Resource.Loading)
        try {
            val movieResponse = apiService.getMovieDetail(movieId)
            val videosResponse = apiService.getMovieVideos(movieId)
            val creditsResponse = apiService.getMovieCredits(movieId)

            val movie = movieResponse.toDomainMovie()

            var video: VideoMovie? = null
            if (videosResponse.results != null && videosResponse.results.isNotEmpty()) {
                video = videosResponse.results[0].toDomainVideoMovie()
            }

            val cast = creditsResponse.cast.map { it.toDomainActor() }
            val crew = creditsResponse.crew.map { it.toDomainProducer() }

            val movieDetail = MovieDetail(
                movie = movieResponse.toDomainMovie(),
                video = video,
                cast = cast,
                crew = crew
            )

            emit(Resource.Success(movieDetail))
        } catch (e: Exception) {
            emit(Resource.Error("Error loading movie details"))
        }
    }


    override fun getMovieMultimedia(movieId: Int): Flow<Resource<MovieMultimedia>> = flow {
        emit(Resource.Loading)
        try {
            val imagesResponse = apiService.getMovieImages(movieId)
            val videosResponse = apiService.getMovieVideos(movieId)

            var image: ImageMovie? = null
            if (imagesResponse.logos != null && imagesResponse.logos.isNotEmpty()) {
                image = imagesResponse.logos[0].toDomainImageMovie()
            }

            var video: VideoMovie? = null
            if (videosResponse.results != null && videosResponse.results.isNotEmpty()) {
                video = videosResponse.results[0].toDomainVideoMovie()
            }

            val movieDetail = MovieMultimedia(
                image = image,
                video = video
            )

            emit(Resource.Success(movieDetail))
        } catch (e: Exception) {
            emit(Resource.Error("Error loading movie"))
        }
    }
}