package com.example.nexus.data.remote

import com.example.nexus.BuildConfig
import com.example.nexus.data.remote.NetworkConstants.DEFAULT_LANGUAGE
import com.example.nexus.data.remote.NetworkConstants.DEFAULT_PAGE
import com.example.nexus.data.remote.models.MovieDto
import com.example.nexus.data.remote.models.MovieResponse
import com.example.nexus.data.remote.models.SeriesDto
import com.example.nexus.data.remote.models.SeriesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("movie/popular")
    suspend fun getMovies(
        @Query("language") language: String = DEFAULT_LANGUAGE,
        @Query("page") page: Int = DEFAULT_PAGE
    ): MovieResponse

    @GET("movie/{movie_id}")
    suspend fun getMovieById(
        @Path("movie_id") movieId: Int,
        @Query("language") language: String = DEFAULT_LANGUAGE
    ): MovieDto

    @GET("search/movie")
    suspend fun searchMovies(
        @Query("query") query: String,
        @Query("language") language: String = DEFAULT_LANGUAGE,
        @Query("page") page: Int = DEFAULT_PAGE
    ): MovieResponse

    @GET("tv/popular")
    suspend fun getSeries(
        @Query("language") language: String = DEFAULT_LANGUAGE,
        @Query("page") page: Int = DEFAULT_PAGE
    ): SeriesResponse

    @GET("tv/{series_id}")
    suspend fun getSeriesById(
        @Path("series_id") seriesId: Int,
        @Query("language") language: String = DEFAULT_LANGUAGE
    ): SeriesDto

    @GET("search/tv")
    suspend fun searchSeries(
        @Query("query") query: String,
        @Query("language") language: String = DEFAULT_LANGUAGE,
        @Query("page") page: Int = DEFAULT_PAGE
    ): SeriesResponse

    @GET("discover/movie")
    suspend fun getMoviesByGenre(
        @Query("with_genres") genreId: Int,
        @Query("language") language: String? = NetworkConstants.DEFAULT_LANGUAGE,
        @Query("page") page: Int = NetworkConstants.DEFAULT_PAGE
    ): MovieResponse

    @GET("discover/tv")
    suspend fun getSeriesByGenre(
        @Query("with_genres") genreId: Int,
        @Query("language") language: String = NetworkConstants.DEFAULT_LANGUAGE,
        @Query("page") page: Int = NetworkConstants.DEFAULT_PAGE
    ): SeriesResponse

}

