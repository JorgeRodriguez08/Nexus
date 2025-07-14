package com.example.nexus.domain.usecase

import com.example.nexus.domain.model.Series
import com.example.nexus.domain.repository.SeriesRepository
import com.example.nexus.utils.Resource
import kotlinx.coroutines.flow.Flow

class GetSeriesByIdUseCase(private val repository: SeriesRepository)  {

    operator fun invoke(seriesId: Int): Flow<Resource<Series>> {
        return repository.getSeriesById(seriesId = seriesId)
    }

}