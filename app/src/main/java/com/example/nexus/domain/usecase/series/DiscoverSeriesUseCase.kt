package com.example.nexus.domain.usecase.series

import com.example.nexus.domain.models.Serie
import com.example.nexus.domain.repository.SeriesRepository
import com.example.nexus.common.Resource
import kotlinx.coroutines.flow.Flow

class DiscoverSeriesUseCase(private val repository: SeriesRepository) {
    operator fun invoke(genreId: String, page: Int, originCountry: String): Flow<Resource<List<Serie>>> =
        repository.discoverSeries(genreId, page, originCountry)
}