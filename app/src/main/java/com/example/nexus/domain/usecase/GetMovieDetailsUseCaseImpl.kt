package com.example.nexus.domain.usecase

import com.example.nexus.domain.model.Movie
import com.example.nexus.domain.repository.MovieRepository
import com.example.nexus.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetMovieDetailsUseCaseImpl(
    private val repository: MovieRepository
) : GetMovieDetailsUseCase {
    override fun invoke(movieId: Int): Flow<Resource<Movie>> = flow {
        emit(Resource.Loading())
        val result = repository.getMovieDetails(movieId = movieId)
        emit(result)
    }
}