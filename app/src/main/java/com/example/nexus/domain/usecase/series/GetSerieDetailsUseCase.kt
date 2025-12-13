package com.example.nexus.domain.usecase.series

import com.example.nexus.common.core.Resource
import com.example.nexus.domain.model.SerieDetails
import com.example.nexus.domain.repository.series.SeriesRepository
import kotlinx.coroutines.flow.Flow

class GetSerieDetailsUseCase(private val repository: SeriesRepository)  {
    operator fun invoke(seriesId: Int): Flow<Resource<SerieDetails>> =
        repository.getSerieDetails(seriesId)
}