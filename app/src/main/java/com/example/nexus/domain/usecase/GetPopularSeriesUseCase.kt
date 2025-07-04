package com.example.nexus.domain.usecase

import com.example.nexus.domain.model.Series
import com.example.nexus.utils.Resource
import kotlinx.coroutines.flow.Flow

interface GetPopularSeriesUseCase {
    operator fun invoke(page: Int): Flow<Resource<List<Series>>>
}