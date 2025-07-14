package com.example.nexus.domain.usecase

import com.example.nexus.domain.repository.SeriesRepository
import com.example.nexus.domain.model.Series
import com.example.nexus.utils.Resource
import kotlinx.coroutines.flow.Flow

class GetSeriesUseCase(private val repository: SeriesRepository)  {

    operator fun invoke(page: Int): Flow<Resource<List<Series>>> {
        return repository.getSeries(page = page)
    }

}