package com.example.nexus.data.repository

import com.example.nexus.data.remote.mappers.toDomainSeries
import com.example.nexus.data.remote.ApiService
import com.example.nexus.domain.model.Series
import com.example.nexus.domain.repository.SeriesRepository
import com.example.nexus.common.Resource
import com.example.nexus.common.safeApiCall
import kotlinx.coroutines.flow.Flow

class SeriesRepositoryImpl(private val apiService: ApiService) : SeriesRepository {

    override fun getSeriesTrending(): Flow<Resource<List<Series>>> =
        safeApiCall {
            apiService.getSeriesTrending().results.map { it.toDomainSeries()}
        }

    override fun getSeriesAiringToday(page: Int): Flow<Resource<List<Series>>> =
        safeApiCall {
            apiService.getSeriesAiringToday(page = page).results.map { it.toDomainSeries() }
        }

    override fun getSeriesOnTheAir(page: Int): Flow<Resource<List<Series>>> =
        safeApiCall {
            apiService.getSeriesOnTheAir(page = page).results.map { it.toDomainSeries() }
        }

    override fun getSeriesPopular(page: Int): Flow<Resource<List<Series>>> =
        safeApiCall {
            apiService.getSeriesPopular(page = page).results.map { it.toDomainSeries() }
        }

    override fun getSeriesTopRated(page: Int): Flow<Resource<List<Series>>> =
        safeApiCall {
            apiService.getSeriesTopRated(page = page).results.map { it.toDomainSeries() }
        }

    override fun discoverSeries(genreId: String, page: Int, originCountry: String): Flow<Resource<List<Series>>> =
        safeApiCall {
            apiService.discoverSeries(genreId = genreId, page = page, originCountry = originCountry).results.map { it.toDomainSeries() }
        }

    override fun searchSeries(query: String, page: Int): Flow<Resource<List<Series>>> =
        safeApiCall {
            apiService.searchSeries(query = query, page = page).results.map { it.toDomainSeries() }
        }

    override fun getSeriesDetails(seriesId: Int): Flow<Resource<Series>> =
        safeApiCall {
            apiService.getSeriesDetails(seriesId = seriesId).toDomainSeries()
        }
}