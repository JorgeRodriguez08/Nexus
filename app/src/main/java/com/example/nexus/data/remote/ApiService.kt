package com.example.nexus.data.remote

import com.example.nexus.data.remote.constants.NetworkConstants
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
    // MOVIES:
    @GET("trending/movie/{time_window}")
    suspend fun getMoviesTrending(
        @Path("time_window") timeWindow: String = "day",
        @Query("language") language: String = NetworkConstants.LANGUAGE_SPANISH
    ): MovieResponse

    @GET("movie/now_playing")
    suspend fun getMoviesNowPlaying(
        @Query("language") language: String = NetworkConstants.LANGUAGE_SPANISH,
        @Query("page") page: Int = NetworkConstants.PAGE_1,
        @Query("region") region: String = NetworkConstants.REGION_US
    ): MovieResponse

    @GET("movie/popular")
    suspend fun getMoviesPopular(
        @Query("language") language: String = NetworkConstants.LANGUAGE_SPANISH,
        @Query("page") page: Int = NetworkConstants.PAGE_1,
        @Query("region") region: String = NetworkConstants.REGION_US
    ): MovieResponse

    @GET("movie/top_rated")
    suspend fun getMoviesTopRated(
        @Query("language") language: String = NetworkConstants.LANGUAGE_SPANISH,
        @Query("page") page: Int = NetworkConstants.PAGE_1,
        @Query("region") region: String = NetworkConstants.REGION_US
    ): MovieResponse

    @GET("movie/upcoming")
    suspend fun getMoviesUpComing(
        @Query("language") language: String = NetworkConstants.LANGUAGE_SPANISH,
        @Query("page") page: Int = NetworkConstants.PAGE_1,
        @Query("region") region: String = NetworkConstants.REGION_US
    ): MovieResponse

    @GET("discover/movie")
    suspend fun discoverMovies(
        @Query("include_adult") includeAdult: Boolean = false,
        @Query("include_video") includeVideo: Boolean = false,
        @Query("language") language: String = NetworkConstants.LANGUAGE_SPANISH,
        @Query("page") page: Int = NetworkConstants.PAGE_1,
        @Query("sort_by") sortBy: String = NetworkConstants.SORT_BY_POP_DESC,
        @Query("release_date.gte") releaseDateGte: String = NetworkConstants.RELEASE_DATE_GTE,
        @Query("release_date.lte") releaseDateLte: String = NetworkConstants.RELEASE_DATE_LTE,
        @Query("vote_average.gte") voteAverageGte: Float = NetworkConstants.VOTE_AVERAGE_GTE,
        @Query("vote_average.lte") voteAverageLte: Float = NetworkConstants.VOTE_AVERAGE_LTE,
        @Query("with_genres") genreId: String,
        @Query("with_origin_country") originCountry: String = NetworkConstants.ORIGIN_COUNTRY_US
    ): MovieResponse

    @GET("search/movie")
    suspend fun searchMovie(
        @Query("query") query: String,
        @Query("include_adult") includeAdult: Boolean = false,
        @Query("language") language: String = NetworkConstants.LANGUAGE_SPANISH,
        @Query("page") page: Int = NetworkConstants.PAGE_1,
        @Query("region") region: String = NetworkConstants.REGION_US
    ): MovieResponse

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
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
        @Query("language") language: String = NetworkConstants.LANGUAGE_SPANISH
    ): VideosMovieResponse

    @GET("movie/{movie_id}/credits")
    suspend fun getMovieCredits(
        @Path("movie_id") movieId: Int,
        @Query("language") language: String = NetworkConstants.LANGUAGE_SPANISH
    ): CreditsResponse

    // SERIES:
    @GET("trending/tv/{time_window}")
    suspend fun getSeriesTrending(
        @Path("time_window") timeWindow: String = "day",
        @Query("language") language: String = NetworkConstants.LANGUAGE_SPANISH
    ): SeriesResponse

    @GET("tv/airing_today")
    suspend fun getSeriesAiringToday(
        @Query("language") language: String = NetworkConstants.LANGUAGE_SPANISH,
        @Query("page") page: Int = NetworkConstants.PAGE_1,
        @Query("timezone") timezone: String = NetworkConstants.REGION_US
    ): SeriesResponse

    @GET("tv/on_the_air")
    suspend fun getSeriesOnTheAir(
        @Query("language") language: String = NetworkConstants.LANGUAGE_SPANISH,
        @Query("page") page: Int = NetworkConstants.PAGE_1,
        @Query("timezone") timezone: String = NetworkConstants.REGION_US
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
    suspend fun discoverSeries(
        @Query("include_adult") includeAdult: Boolean = false,
        @Query("include_video") includeVideo: Boolean = false,
        @Query("language") language: String = NetworkConstants.LANGUAGE_SPANISH,
        @Query("page") page: Int = NetworkConstants.PAGE_1,
        @Query("sort_by") sortBy: String = NetworkConstants.SORT_BY_POP_DESC,
        @Query("first_air_date.gte") firstAirDateGte: String = NetworkConstants.FIRST_AIR_DATE_GTE,
        @Query("first_air_date.lte") firstAirDateLte: String = NetworkConstants.FIRST_AIR_DATE_LTE,
        @Query("vote_average") voteAverage: Float = NetworkConstants.VOTE_AVERAGE_GTE,
        @Query("with_genres") genreId: String,
        @Query("with_origin_country") originCountry: String = NetworkConstants.ORIGIN_COUNTRY_US
    ): SeriesResponse

    @GET("search/tv")
    suspend fun searchSeries(
        @Query("query") query: String,
        @Query("include_adult") includeAdult: Boolean = false,
        @Query("language") language: String = NetworkConstants.LANGUAGE_SPANISH,
        @Query("page") page: Int = NetworkConstants.PAGE_1
    ): SeriesResponse

    @GET("tv/{series_id}")
    suspend fun getSeriesDetails(
        @Path("series_id") seriesId: Int,
        @Query("language") language: String = NetworkConstants.LANGUAGE_SPANISH
    ): SeriesDto
}

