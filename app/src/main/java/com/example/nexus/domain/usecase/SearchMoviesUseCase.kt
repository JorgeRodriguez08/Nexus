package com.example.nexus.domain.usecase

import com.example.nexus.domain.model.Movie
import com.example.nexus.utils.Resource
import kotlinx.coroutines.flow.Flow

interface SearchMoviesUseCase {
    operator fun invoke(query: String, page: Int): Flow<Resource<List<Movie>>>
}