package com.example.nexus.data.remote

import com.example.nexus.data.remote.constants.NetworkConstants
import com.example.nexus.data.remote.models.MovieDto
import com.example.nexus.data.remote.models.MovieResponse
import com.example.nexus.data.remote.models.SeriesDto
import com.example.nexus.data.remote.models.SeriesResponse
import com.example.nexus.data.remote.models.VideoDto
import com.example.nexus.data.remote.models.VideoResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("movie/now_playing")
    suspend fun getMoviesNowPlaying(
        @Query("language") language: String = NetworkConstants.DEFAULT_LANGUAGE,
        @Query("page") page: Int = NetworkConstants.DEFAULT_PAGE,
        @Query("sort_by") sortBy: String = "popularity.desc"
    ): MovieResponse

    @GET("movie/popular")
    suspend fun getMoviesPopular(
        @Query("language") language: String = NetworkConstants.DEFAULT_LANGUAGE,
        @Query("page") page: Int = NetworkConstants.DEFAULT_PAGE,
        @Query("sort_by") sortBy: String = "popularity.desc"
    ): MovieResponse

    @GET("movie/top_rated")
    suspend fun getMoviesTopRated(
        @Query("language") language: String = NetworkConstants.DEFAULT_LANGUAGE,
        @Query("page") page: Int = NetworkConstants.DEFAULT_PAGE,
        @Query("sort_by") sortBy: String = "popularity.desc"
    ): MovieResponse

    @GET("movie/upcoming")
    suspend fun getMoviesUpComing(
        @Query("language") language: String = NetworkConstants.DEFAULT_LANGUAGE,
        @Query("page") page: Int = NetworkConstants.DEFAULT_PAGE,
        @Query("sort_by") sortBy: String = "popularity.desc"
    ): MovieResponse

    @GET("discover/movie")
    suspend fun getMoviesByGenre(
        @Query("with_genres") genreId: Int,
        @Query("language") language: String = NetworkConstants.DEFAULT_LANGUAGE,
        @Query("page") page: Int = NetworkConstants.DEFAULT_PAGE,
        @Query("sort_by") sortBy: String = "popularity.desc"
    ): MovieResponse

    @GET("movie/{movie_id}")
    suspend fun getMovieById(
        @Path("movie_id") movieId: Int,
        @Query("language") language: String = NetworkConstants.DEFAULT_LANGUAGE
    ): MovieDto

    @GET("movie/{movie_id}/videos")
    suspend fun getMovieVideos(
        @Path("movie_id") movieId: Int,
    ): VideoResponse

    @GET("search/movie")
    suspend fun searchMovies(
        @Query("query") query: String,
        @Query("language") language: String = NetworkConstants.DEFAULT_LANGUAGE,
        @Query("page") page: Int = NetworkConstants.DEFAULT_PAGE
    ): MovieResponse


    @GET("tv/airing_today")
    suspend fun getSeriesAiringToday(
        @Query("language") language: String = NetworkConstants.DEFAULT_LANGUAGE,
        @Query("page") page: Int = NetworkConstants.DEFAULT_PAGE
    ): SeriesResponse

    @GET("tv/on_the_air")
    suspend fun getSeriesOnTheAir(
        @Query("language") language: String = NetworkConstants.DEFAULT_LANGUAGE,
        @Query("page") page: Int = NetworkConstants.DEFAULT_PAGE
    ): SeriesResponse

    @GET("tv/popular")
    suspend fun getSeriesPopular(
        @Query("language") language: String = NetworkConstants.DEFAULT_LANGUAGE,
        @Query("page") page: Int = NetworkConstants.DEFAULT_PAGE
    ): SeriesResponse

    @GET("tv/top_rated")
    suspend fun getSeriesTopRated(
        @Query("language") language: String = NetworkConstants.DEFAULT_LANGUAGE,
        @Query("page") page: Int = NetworkConstants.DEFAULT_PAGE
    ): SeriesResponse

    @GET("discover/tv")
    suspend fun getSeriesByGenre(
        @Query("with_genres") genreId: Int,
        @Query("language") language: String = NetworkConstants.DEFAULT_LANGUAGE,
        @Query("page") page: Int = NetworkConstants.DEFAULT_PAGE,
        @Query("sort_by") sortBy: String = "popularity.desc"
    ): SeriesResponse

    @GET("search/tv")
    suspend fun searchSeries(
        @Query("query") query: String,
        @Query("language") language: String = NetworkConstants.DEFAULT_LANGUAGE,
        @Query("page") page: Int = NetworkConstants.DEFAULT_PAGE
    ): SeriesResponse

    @GET("tv/{series_id}")
    suspend fun getSeriesById(
        @Path("series_id") seriesId: Int,
        @Query("language") language: String = NetworkConstants.DEFAULT_LANGUAGE
    ): SeriesDto

}

