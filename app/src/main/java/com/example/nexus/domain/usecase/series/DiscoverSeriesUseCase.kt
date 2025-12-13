package com.example.nexus.domain.usecase.series

import com.example.nexus.domain.model.Serie
import com.example.nexus.domain.repository.series.SeriesRepository
import com.example.nexus.common.core.Resource
import kotlinx.coroutines.flow.Flow

class DiscoverSeriesUseCase(private val repository: SeriesRepository) {
    operator fun invoke(genreId: String, page: Int, originCountry: String): Flow<Resource<List<Serie>>> =
        repository.discoverSeries(genreId, page, originCountry)
}