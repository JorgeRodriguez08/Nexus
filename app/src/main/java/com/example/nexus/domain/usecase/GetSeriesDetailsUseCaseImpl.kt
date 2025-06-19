package com.example.nexus.domain.usecase

import com.example.nexus.domain.model.Series
import com.example.nexus.domain.repository.SeriesRepository
import com.example.nexus.untils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetSeriesDetailsUseCaseImpl(
    private val repository: SeriesRepository
) : GetSeriesDetailsUseCase {
    override fun invoke(seriesId: Int): Flow<Resource<Series>> = flow {
        emit(Resource.Loading())
        val result = repository.getSeriesDetails(seriesId = seriesId)
        emit(result)
    }
}