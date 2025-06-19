package com.example.nexus.data.remote

import com.example.nexus.BuildConfig
import com.example.nexus.data.remote.models.MovieDto
import com.example.nexus.data.remote.models.MovieResponse
import com.example.nexus.data.remote.models.SeriesDto
import com.example.nexus.data.remote.models.SeriesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    // The Movies
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY,
        @Query("language") language: String = "en-Us",
        @Query("page") page: Int = 1
    ): MovieResponse

    @GET("movie/{movie_id}")
    suspend fun getDetailsMovies(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY,
        @Query("language") language: String = "en-Us"
    ): MovieDto

    @GET("search/movie")
    suspend fun searchMovie(
        @Query("query") query: String,
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY,
        @Query("language") language: String = "en-Us",
        @Query("page") page: Int = 1
    ): MovieResponse

    // The Series
    @GET("tv/popular")
    suspend fun getPopularSeries(
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY,
        @Query("language") language: String = "en-Us",
        @Query("page") page: Int = 1
    ): SeriesResponse

    @GET("tv/{series_id}")
    suspend fun getDetailsSeries(
        @Path("series_id") seriesId: Int,
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY,
        @Query("language") language: String = "en-Us"
    ): SeriesDto

    @GET("search/tv")
    suspend fun searchSeries(
        @Query("query") query: String,
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY,
        @Query("language") language: String = "en-Us",
        @Query("page") page: Int = 1
    ): SeriesResponse
}

