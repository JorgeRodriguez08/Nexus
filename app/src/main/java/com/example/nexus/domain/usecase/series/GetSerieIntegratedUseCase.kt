package com.example.nexus.domain.usecase.series

import com.example.nexus.common.core.Resource
import com.example.nexus.domain.model.SerieIntegrated
import com.example.nexus.domain.repository.series.SeriesRepository
import kotlinx.coroutines.flow.Flow

class GetSerieIntegratedUseCase(private val repository: SeriesRepository)  {
    operator fun invoke(serieId: Int): Flow<Resource<SerieIntegrated>> =
        repository.getSerieIntegrated(serieId)
}