package com.example.nexus.data.repository

import com.example.nexus.data.remote.ApiService
import com.example.nexus.data.mappers.toDomainSeries
import com.example.nexus.domain.model.Series
import com.example.nexus.domain.repository.SeriesRepository
import com.example.nexus.untils.Resource
import retrofit2.HttpException
import java.io.IOException

class SeriesRepositoryImpl(
    private val apiService: ApiService
) : SeriesRepository {
    override suspend fun getPopularSeries(page: Int): Resource<List<Series>> {
        return try {
            val response = apiService.getPopularSeries(page = page)
            if (response.results.isNotEmpty()) {
                val domainSeries = response.results.map { it.toDomainSeries() }
                Resource.Success(domainSeries)
            } else {
                Resource.Error("No popular series found. ")
            }
        } catch (e: HttpException) {
            // HTTP error (e.g., 404, 500)
            Resource.Error(e.localizedMessage ?: "An unexpected networking error occurred")
        } catch (e: IOException) {
            // Network error (no internet connection, DNC, etc.)
            Resource.Error("Could not connected to the server. Please check your internet connection")
        } catch (e: Exception) {
            // Other generic errors
            Resource.Error(e.localizedMessage ?: "An unknown error occurred")
        }
    }

    override suspend fun getSeriesDetails(seriesId: Int): Resource<Series> {
        return try {
            val response = apiService.getDetailsSeries(seriesId = seriesId)
            val domainSeriesDetails = response.toDomainSeries()
            Resource.Success(domainSeriesDetails)
        } catch (e: HttpException) {
            // HTTP error (e.g., 404, 500)
            Resource.Error(e.localizedMessage ?: "An unexpected networking error occurred")
        } catch (e: IOException) {
            // Network error (no internet connection, DNC, etc.)
            Resource.Error("Could not connect to the server. Please check your internet connection.")
        } catch (e: Exception) {
            // Other generic errors.
            Resource.Error(e.localizedMessage ?: "An unknown error occurred")
        }
    }

    override suspend fun searchSeries(query: String, page: Int): Resource<List<Series>> {
        return try {
            val response = apiService.searchSeries(query = query, page = page)
            if (!response.results.isNotEmpty()) {
                val domainSeriesFound = response.results.map { it.toDomainSeries() }
                Resource.Success(domainSeriesFound)
            } else {
                Resource.Error("No search series found")
            }
        } catch (e: HttpException) {
            Resource.Error(e.localizedMessage ?: "An unexpected networking error occurred")
        } catch (e: IOException) {
            Resource.Error("Could not connect to the server. Please check your internet connection.")
        } catch (e: Exception) {
            Resource.Error(e.localizedMessage ?: "An unknown error occurred")
        }
    }
}