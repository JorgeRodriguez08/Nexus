package com.example.nexus.domain.usecase

import com.example.nexus.domain.model.Movie
import com.example.nexus.domain.repository.MovieRepository
import com.example.nexus.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetPopularMoviesUseCaseImpl(
    private val repository: MovieRepository
) : GetPopularMoviesUseCase {
    override operator fun invoke(page: Int): Flow<Resource<List<Movie>>> = flow {
        emit(Resource.Loading())
        val result = repository.getPopularMovies(page = page)
        emit(result)
    }
}