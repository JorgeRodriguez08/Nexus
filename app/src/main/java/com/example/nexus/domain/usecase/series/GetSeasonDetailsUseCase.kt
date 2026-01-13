package com.example.nexus.domain.usecase.series

import com.example.nexus.common.core.Resource
import com.example.nexus.domain.model.SeasonDetails
import com.example.nexus.domain.repository.series.SeriesRepository
import kotlinx.coroutines.flow.Flow

data class GetSeasonDetailsUseCase(private val repository: SeriesRepository) {
    operator fun invoke(serieId: Int, seasonNumber: Int): Flow<Resource<SeasonDetails>> =
        repository.getSeasonDetails(serieId, seasonNumber)
}
