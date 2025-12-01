package com.example.nexus.domain.usecase.series

import com.example.nexus.domain.model.Series
import com.example.nexus.domain.repository.SeriesRepository
import com.example.nexus.common.Resource
import kotlinx.coroutines.flow.Flow

class SearchSeriesUseCase(private val repository: SeriesRepository) {
    operator fun invoke(query: String, page: Int): Flow<Resource<List<Series>>> =
        repository.searchSeries(query, page)
}