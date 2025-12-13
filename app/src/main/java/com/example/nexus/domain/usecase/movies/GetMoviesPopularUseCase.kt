package com.example.nexus.domain.usecase.movies

import com.example.nexus.common.core.Resource
import com.example.nexus.domain.model.Movie
import com.example.nexus.domain.repository.movies.MoviesRepository
import kotlinx.coroutines.flow.Flow

class GetMoviesPopularUseCase(private val repository: MoviesRepository)  {
    operator fun invoke(page: Int): Flow<Resource<List<Movie>>> =
        repository.getMoviesPopular(page)
}