package com.example.nexus.data.repository

import com.example.nexus.data.mappers.toDomainSeries
import com.example.nexus.data.remote.ApiService
import com.example.nexus.domain.model.Series
import com.example.nexus.domain.repository.SeriesRepository
import com.example.nexus.utils.ErrorMessages
import com.example.nexus.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class SeriesRepositoryImpl(private val apiService: ApiService) : SeriesRepository {

    override fun getSeries(page: Int): Flow<Resource<List<Series>>> = flow {
        emit(Resource.Loading())
        try {
            val response = apiService.getSeries(page = page)
            val domainSeries = response.results.map { it.toDomainSeries() }
            if (domainSeries.isNotEmpty()) {
                emit(Resource.Success(domainSeries))
            } else {
                emit(Resource.Error(ErrorMessages.NO_POPULAR_MOVIES))
            }
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: ErrorMessages.HTTP))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: ErrorMessages.NETWORK))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: ErrorMessages.UNKNOWN))
        }
    }

    override fun getSeriesById(seriesId: Int): Flow<Resource<Series>> = flow {
        emit(Resource.Loading())
        try {
            val response = apiService.getSeriesById(seriesId = seriesId)
            emit(Resource.Success(response.toDomainSeries()))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: ErrorMessages.HTTP))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: ErrorMessages.NETWORK))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: ErrorMessages.UNKNOWN))
        }
    }

    override fun searchSeries(query: String, page: Int): Flow<Resource<List<Series>>> = flow {
        emit(Resource.Loading())
        try {
            val response = apiService.searchSeries(query = query, page = page)
            val domainSeries = response.results.map { it.toDomainSeries() }
            if (domainSeries.isNotEmpty()) {
                emit(Resource.Success(domainSeries))
            } else {
                emit(Resource.Error(ErrorMessages.NO_POPULAR_MOVIES))
            }
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: ErrorMessages.HTTP))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: ErrorMessages.NETWORK))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: ErrorMessages.UNKNOWN))
        }
    }

    override fun getSeriesByGenre(genreId: Int, language: String, page: Int): Flow<Resource<List<Series>>> = flow {
        emit(Resource.Loading())
        try {
            val response = apiService.getSeriesByGenre(genreId = genreId, language = language, page = page)
            val domainSeries = response.results.map { it.toDomainSeries() }
            if (domainSeries.isNotEmpty()) {
                emit(Resource.Success(domainSeries))
            } else {
                emit(Resource.Error(ErrorMessages.NO_POPULAR_MOVIES))
            }
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: ErrorMessages.HTTP))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: ErrorMessages.NETWORK))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: ErrorMessages.UNKNOWN))
        }
    }

}