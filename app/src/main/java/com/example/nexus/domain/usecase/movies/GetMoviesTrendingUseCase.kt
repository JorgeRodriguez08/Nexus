package com.example.nexus.domain.usecase.movies

import com.example.nexus.common.core.Resource
import com.example.nexus.domain.model.Movie
import com.example.nexus.domain.repository.movies.MoviesRepository
import kotlinx.coroutines.flow.Flow

class GetMoviesTrendingUseCase(private val repository: MoviesRepository) {
    operator fun invoke(): Flow<Resource<List<Movie>>> =
        repository.getMoviesTrending()
}