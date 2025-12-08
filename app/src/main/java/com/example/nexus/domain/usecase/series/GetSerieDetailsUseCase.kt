package com.example.nexus.domain.usecase.series

import com.example.nexus.domain.models.Serie
import com.example.nexus.domain.repository.SeriesRepository
import com.example.nexus.common.Resource
import kotlinx.coroutines.flow.Flow

class GetSerieDetailsUseCase(private val repository: SeriesRepository)  {
    operator fun invoke(seriesId: Int): Flow<Resource<Serie>> =
        repository.getSerieDetails(seriesId)
}