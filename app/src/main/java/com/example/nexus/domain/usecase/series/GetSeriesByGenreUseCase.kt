package com.example.nexus.domain.usecase.series

import com.example.nexus.domain.model.Series
import com.example.nexus.domain.repository.SeriesRepository
import com.example.nexus.common.core.Resource
import kotlinx.coroutines.flow.Flow

class GetSeriesByGenreUseCase(private val repository: SeriesRepository) {

    operator fun invoke(genreId: String, page: Int): Flow<Resource<List<Series>>> =
        repository.getSeriesByGenre(genreId, page)

}