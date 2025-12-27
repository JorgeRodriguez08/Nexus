package com.example.nexus.data.repository.series

import com.example.nexus.common.constants.ErrorMessages
import com.example.nexus.common.core.Resource
import com.example.nexus.common.utils.safeApiCall
import com.example.nexus.data.remote.api.ApiService
import com.example.nexus.data.remote.mapper.toDomainActor
import com.example.nexus.data.remote.mapper.toDomainProducer
import com.example.nexus.data.remote.mapper.toDomainSerie
import com.example.nexus.domain.model.Serie
import com.example.nexus.domain.model.SerieDetails
import com.example.nexus.domain.repository.series.SeriesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import java.io.IOException

class SeriesRepositoryImpl(private val apiService: ApiService) : SeriesRepository {
    override fun getSeriesTrending(): Flow<Resource<List<Serie>>> =
        safeApiCall {
            apiService.getSeriesTrending().results.map { it.toDomainSerie() }
        }.flowOn(Dispatchers.IO)

    override fun getSeriesAiringToday(page: Int): Flow<Resource<List<Serie>>> =
        safeApiCall {
            apiService.getSeriesAiringToday(page = page).results.map { it.toDomainSerie() }
        }.flowOn(Dispatchers.IO)

    override fun getSeriesOnTheAir(page: Int): Flow<Resource<List<Serie>>> =
        safeApiCall {
            apiService.getSeriesOnTheAir(page = page).results.map { it.toDomainSerie() }
        }.flowOn(Dispatchers.IO)

    override fun getSeriesPopular(page: Int): Flow<Resource<List<Serie>>> =
        safeApiCall {
            apiService.getSeriesPopular(page = page).results.map { it.toDomainSerie() }
        }.flowOn(Dispatchers.IO)

    override fun getSeriesTopRated(page: Int): Flow<Resource<List<Serie>>> =
        safeApiCall {
            apiService.getSeriesTopRated(page = page).results.map { it.toDomainSerie() }
        }.flowOn(Dispatchers.IO)

    override fun discoverSeries(genreId: String, page: Int, originCountry: String): Flow<Resource<List<Serie>>> =
        safeApiCall {
            apiService.discoverSeries(
                genreId = genreId,
                page = page,
                originCountry = originCountry
            ).results.map { it.toDomainSerie() }
        }.flowOn(Dispatchers.IO)

    override fun searchSeries(query: String, page: Int): Flow<Resource<List<Serie>>> =
        safeApiCall {
            apiService.searchSeries(query = query, page = page).results.map { it.toDomainSerie() }
        }.flowOn(Dispatchers.IO)

    override fun getSerieDetails(seriesId: Int): Flow<Resource<SerieDetails>> =
        flow {
            emit(Resource.Loading)
            try {
                val serieResponse = apiService.getSerieDetails(seriesId)
                val creditsResponse = apiService.getSerieCredits(seriesId)

                val serie = serieResponse.toDomainSerie()
                val cast = creditsResponse.cast.map { it.toDomainActor() }
                val crew = creditsResponse.crew.map { it.toDomainProducer() }

                val serieDetails = SerieDetails(
                    serie = serie,
                    cast = cast,
                    crew = crew
                )
                emit(Resource.Success(serieDetails))
            } catch (e: HttpException) {
                emit(Resource.Error(e.localizedMessage ?: ErrorMessages.HTTP))
            } catch (e: IOException) {
                emit(Resource.Error(e.localizedMessage ?: ErrorMessages.NETWORK))
            } catch (e: Exception) {
                emit(Resource.Error(e.localizedMessage ?: ErrorMessages.UNKNOWN))
            }
        }.flowOn(Dispatchers.IO)
}