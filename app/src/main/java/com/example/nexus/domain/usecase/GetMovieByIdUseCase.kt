package com.example.nexus.domain.usecase

import com.example.nexus.domain.model.Movie
import com.example.nexus.domain.repository.MovieRepository
import com.example.nexus.utils.Resource
import kotlinx.coroutines.flow.Flow

class GetMovieByIdUseCase(private val repository: MovieRepository) {

    operator fun invoke(movieId: Int): Flow<Resource<Movie>> {
        return repository.getMovieById(movieId = movieId)
    }

}