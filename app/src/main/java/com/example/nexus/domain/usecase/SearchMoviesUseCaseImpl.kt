package com.example.nexus.domain.usecase

import com.example.nexus.domain.model.Movie
import com.example.nexus.domain.repository.MovieRepository
import com.example.nexus.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchMoviesUseCaseImpl(
    private val repository: MovieRepository
) : SearchMoviesUseCase {
    override operator fun invoke(query: String, page: Int): Flow<Resource<List<Movie>>> = flow {
        emit(Resource.Loading())
        val result = repository.searchMovies(query = query, page = page)
        emit(result)
    }
}