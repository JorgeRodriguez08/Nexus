package com.example.nexus.domain.repository

import com.example.nexus.domain.model.Series
import com.example.nexus.common.Resource
import kotlinx.coroutines.flow.Flow

interface SeriesRepository {
    fun getSeriesTrending(): Flow<Resource<List<Series>>>

    fun getSeriesAiringToday(page: Int): Flow<Resource<List<Series>>>

    fun getSeriesOnTheAir(page: Int): Flow<Resource<List<Series>>>

    fun getSeriesPopular(page: Int): Flow<Resource<List<Series>>>

    fun getSeriesTopRated(page: Int): Flow<Resource<List<Series>>>

    fun discoverSeries(genreId: String, page: Int, originCountry: String): Flow<Resource<List<Series>>>

    fun searchSeries(query: String, page: Int): Flow<Resource<List<Series>>>

    fun getSeriesDetails(seriesId: Int): Flow<Resource<Series>>
}
