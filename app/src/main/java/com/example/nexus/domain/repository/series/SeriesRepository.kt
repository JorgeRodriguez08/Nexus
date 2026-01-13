package com.example.nexus.domain.repository.series

import com.example.nexus.common.core.Resource
import com.example.nexus.domain.model.SeasonDetails
import com.example.nexus.domain.model.Serie
import com.example.nexus.domain.model.SerieDetails
import com.example.nexus.domain.model.SerieIntegrated
import kotlinx.coroutines.flow.Flow

interface SeriesRepository {
    fun getSeriesTrending(): Flow<Resource<List<Serie>>>
    fun getSeriesAiringToday(page: Int): Flow<Resource<List<Serie>>>
    fun getSeriesOnTheAir(page: Int): Flow<Resource<List<Serie>>>
    fun getSeriesPopular(page: Int): Flow<Resource<List<Serie>>>
    fun getSeriesTopRated(page: Int): Flow<Resource<List<Serie>>>
    fun discoverSeries(genreId: String, page: Int, originCountry: String): Flow<Resource<List<Serie>>>
    fun searchSeries(query: String, page: Int): Flow<Resource<List<Serie>>>
    fun getSerieIntegrated(serieId: Int): Flow<Resource<SerieIntegrated>>
    fun getSerieDetails(serieId: Int): Flow<Resource<SerieDetails>>
    fun getSeasonDetails(serieId: Int, seasonNumber: Int): Flow<Resource<SeasonDetails>>
}