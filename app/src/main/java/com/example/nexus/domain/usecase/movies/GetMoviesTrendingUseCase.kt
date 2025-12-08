package com.example.nexus.domain.usecase.movies

import com.example.nexus.common.Resource
import com.example.nexus.domain.models.Movie
import com.example.nexus.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow

class GetMoviesTrendingUseCase(private val repository: MoviesRepository) {
    operator fun invoke(): Flow<Resource<List<Movie>>> =
        repository.getMoviesTrending()
}