package com.example.nexus.domain.usecase.series

import com.example.nexus.common.Resource
import com.example.nexus.domain.model.Series
import com.example.nexus.domain.repository.SeriesRepository
import kotlinx.coroutines.flow.Flow

class GetSeriesTrendingUseCase(private val repository: SeriesRepository) {
    operator fun invoke(): Flow<Resource<List<Series>>> =
        repository.getSeriesTrending()
}

