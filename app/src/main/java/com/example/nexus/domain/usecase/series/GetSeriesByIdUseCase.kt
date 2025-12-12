package com.example.nexus.domain.usecase.series

import com.example.nexus.domain.model.Series
import com.example.nexus.domain.repository.SeriesRepository
import com.example.nexus.common.core.Resource
import kotlinx.coroutines.flow.Flow

class GetSeriesByIdUseCase(private val repository: SeriesRepository)  {

    operator fun invoke(seriesId: Int): Flow<Resource<Series>> =
        repository.getSeriesById(seriesId = seriesId)

}