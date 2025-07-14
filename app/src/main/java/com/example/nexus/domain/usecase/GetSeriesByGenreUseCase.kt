package com.example.nexus.domain.usecase

import com.example.nexus.domain.model.Series
import com.example.nexus.domain.repository.SeriesRepository
import com.example.nexus.utils.Resource
import kotlinx.coroutines.flow.Flow

class GetSeriesByGenreUseCase(private val repository: SeriesRepository) {

    operator fun invoke(genreId: Int, language: String, page: Int): Flow<Resource<List<Series>>> {
        return repository.getSeriesByGenre(genreId, language, page)
    }

}