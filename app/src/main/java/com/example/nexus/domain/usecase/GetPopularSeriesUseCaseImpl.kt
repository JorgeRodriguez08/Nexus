package com.example.nexus.domain.usecase

import com.example.nexus.domain.model.Series
import com.example.nexus.domain.repository.SeriesRepository
import com.example.nexus.untils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetPopularSeriesUseCaseImpl(
    private val repository: SeriesRepository
) : GetPopularSeriesUseCase {
    override operator fun invoke(page: Int): Flow<Resource<List<Series>>> = flow {
        emit(Resource.Loading())
        val result = repository.getPopularSeries(page = page)
        emit(result)
    }
}