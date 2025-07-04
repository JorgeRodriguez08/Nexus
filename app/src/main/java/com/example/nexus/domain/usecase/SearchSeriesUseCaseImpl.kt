package com.example.nexus.domain.usecase

import com.example.nexus.domain.model.Series
import com.example.nexus.domain.repository.SeriesRepository
import com.example.nexus.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchSeriesUseCaseImpl(
    private val repository: SeriesRepository
) : SearchSeriesUseCase {
    override operator fun invoke(query: String, page: Int): Flow<Resource<List<Series>>> = flow {
        emit(Resource.Loading())
        val result = repository.searchSeries(query = query, page = page)
        emit(result)
    }
}