package com.example.nexus.data.remote

import com.example.nexus.common.constants.NetworkConstants
import com.example.nexus.data.remote.models.CreditsResponse
import com.example.nexus.data.remote.models.ImagesMovieResponse
import com.example.nexus.data.remote.models.MovieDto
import com.example.nexus.data.remote.models.MovieResponse
import com.example.nexus.data.remote.models.SeriesDto
import com.example.nexus.data.remote.models.SeriesResponse
import com.example.nexus.data.remote.models.VideosMovieResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    // Movie Endpoints
    @GET("movie/now_playing")
    suspend fun getMoviesNowPlaying(
        @Query("language") language: String = NetworkConstants.LANGUAGE_SPANISH,
        @Query("page") page: Int = NetworkConstants.PAGE_1,
        @Query("sort_by") sortBy: String = "popularity.desc"
    ): MovieResponse

    @GET("movie/popular")
    suspend fun getMoviesPopular(
        @Query("language") language: String = NetworkConstants.LANGUAGE_SPANISH,
        @Query("page") page: Int = NetworkConstants.PAGE_1,
        @Query("sort_by") sortBy: String = "popularity.desc"
    ): MovieResponse

    @GET("movie/top_rated")
    suspend fun getMoviesTopRated(
        @Query("language") language: String = NetworkConstants.LANGUAGE_SPANISH,
        @Query("page") page: Int = NetworkConstants.PAGE_1,
        @Query("sort_by") sortBy: String = "popularity.desc"
    ): MovieResponse

    @GET("movie/upcoming")
    suspend fun getMoviesUpComing(
        @Query("language") language: String = NetworkConstants.LANGUAGE_SPANISH,
        @Query("page") page: Int = NetworkConstants.PAGE_1,
        @Query("sort_by") sortBy: String = "popularity.desc"
    ): MovieResponse

    @GET("discover/movie")
    suspend fun getMoviesByGenre(
        @Query("with_genres") genreId: String,
        @Query("language") language: String = NetworkConstants.LANGUAGE_SPANISH,
        @Query("page") page: Int = NetworkConstants.PAGE_1,
        @Query("sort_by") sortBy: String = "popularity.desc"
    ): MovieResponse

    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(
        @Path("movie_id") movieId: Int,
        @Query("language") language: String = NetworkConstants.LANGUAGE_SPANISH
    ): MovieDto

    @GET("movie/{movie_id}/images")
    suspend fun getMovieImages(
        @Path("movie_id") movieId: Int,
        @Query("language") language: String = NetworkConstants.LANGUAGE_SPANISH
    ): ImagesMovieResponse

    @GET("movie/{movie_id}/videos")
    suspend fun getMovieVideos(
        @Path("movie_id") movieId: Int,
    ): VideosMovieResponse

    @GET("search/movie")
    suspend fun searchMovies(
        @Query("query") query: String,
        @Query("language") language: String = NetworkConstants.LANGUAGE_SPANISH,
        @Query("page") page: Int = NetworkConstants.PAGE_1
    ): MovieResponse

    @GET("movie/{movie_id}/credits")
    suspend fun getMovieCredits(
        @Path("movie_id") movieId: Int,
        @Query("language") language: String = NetworkConstants.LANGUAGE_SPANISH
    ) : CreditsResponse


    // TV Series Endpoints
    @GET("tv/airing_today")
    suspend fun getSeriesAiringToday(
        @Query("language") language: String = NetworkConstants.LANGUAGE_SPANISH,
        @Query("page") page: Int = NetworkConstants.PAGE_1
    ): SeriesResponse

    @GET("tv/on_the_air")
    suspend fun getSeriesOnTheAir(
        @Query("language") language: String = NetworkConstants.LANGUAGE_SPANISH,
        @Query("page") page: Int = NetworkConstants.PAGE_1
    ): SeriesResponse

    @GET("tv/popular")
    suspend fun getSeriesPopular(
        @Query("language") language: String = NetworkConstants.LANGUAGE_SPANISH,
        @Query("page") page: Int = NetworkConstants.PAGE_1
    ): SeriesResponse

    @GET("tv/top_rated")
    suspend fun getSeriesTopRated(
        @Query("language") language: String = NetworkConstants.LANGUAGE_SPANISH,
        @Query("page") page: Int = NetworkConstants.PAGE_1
    ): SeriesResponse

    @GET("discover/tv")
    suspend fun getSeriesByGenre(
        @Query("with_genres") genreId: String,
        @Query("language") language: String = NetworkConstants.LANGUAGE_SPANISH,
        @Query("page") page: Int = NetworkConstants.PAGE_1,
        @Query("sort_by") sortBy: String = "popularity.desc"
    ): SeriesResponse

    @GET("search/tv")
    suspend fun searchSeries(
        @Query("query") query: String,
        @Query("language") language: String = NetworkConstants.LANGUAGE_SPANISH,
        @Query("page") page: Int = NetworkConstants.PAGE_1
    ): SeriesResponse

    @GET("tv/{series_id}")
    suspend fun getSeriesById(
        @Path("series_id") seriesId: Int,
        @Query("language") language: String = NetworkConstants.LANGUAGE_SPANISH
    ): SeriesDto

}

