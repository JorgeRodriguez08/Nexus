package com.example.nexus.domain.usecase.series

import com.example.nexus.domain.repository.SeriesRepository
import com.example.nexus.domain.model.Series
import com.example.nexus.common.Resource
import kotlinx.coroutines.flow.Flow

class GetSeriesPopularUseCase(private val repository: SeriesRepository)  {
    operator fun invoke(page: Int): Flow<Resource<List<Series>>> =
        repository.getSeriesPopular(page)
}