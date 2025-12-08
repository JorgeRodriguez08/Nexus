package com.example.nexus.domain.usecase.series

import com.example.nexus.domain.models.Serie
import com.example.nexus.domain.repository.SeriesRepository
import com.example.nexus.common.Resource
import kotlinx.coroutines.flow.Flow

class SearchSerieUseCase(private val repository: SeriesRepository) {
    operator fun invoke(query: String, page: Int): Flow<Resource<List<Serie>>> =
        repository.searchSeries(query, page)
}