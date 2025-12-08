package com.example.nexus.domain.repository

import com.example.nexus.domain.models.Serie
import com.example.nexus.common.Resource
import com.example.nexus.domain.models.SerieDetails
import kotlinx.coroutines.flow.Flow

interface SeriesRepository {
    fun getSeriesTrending(): Flow<Resource<List<Serie>>>
    fun getSeriesAiringToday(page: Int): Flow<Resource<List<Serie>>>
    fun getSeriesOnTheAir(page: Int): Flow<Resource<List<Serie>>>
    fun getSeriesPopular(page: Int): Flow<Resource<List<Serie>>>
    fun getSeriesTopRated(page: Int): Flow<Resource<List<Serie>>>
    fun discoverSeries(genreId: String, page: Int, originCountry: String): Flow<Resource<List<Serie>>>
    fun searchSeries(query: String, page: Int): Flow<Resource<List<Serie>>>
    fun getSerieDetails(seriesId: Int): Flow<Resource<SerieDetails>>
}
