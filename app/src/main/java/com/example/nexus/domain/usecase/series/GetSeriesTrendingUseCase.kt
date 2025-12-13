package com.example.nexus.domain.usecase.series

import com.example.nexus.common.core.Resource
import com.example.nexus.domain.model.Serie
import com.example.nexus.domain.repository.series.SeriesRepository
import kotlinx.coroutines.flow.Flow

class GetSeriesTrendingUseCase(private val repository: SeriesRepository) {
    operator fun invoke(): Flow<Resource<List<Serie>>> =
        repository.getSeriesTrending()
}