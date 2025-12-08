package com.example.nexus.domain.usecase.movies

import com.example.nexus.domain.models.Movie
import com.example.nexus.domain.repository.MoviesRepository
import com.example.nexus.common.Resource
import kotlinx.coroutines.flow.Flow

class GetMoviesTopRatedUseCase(private val repository: MoviesRepository) {
    operator fun invoke(page: Int): Flow<Resource<List<Movie>>> =
        repository.getMoviesTopRated(page)
}