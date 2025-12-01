package com.example.nexus.domain.usecase.movies

import com.example.nexus.domain.model.Movie
import com.example.nexus.domain.repository.MovieRepository
import com.example.nexus.common.Resource
import kotlinx.coroutines.flow.Flow

class GetMovieDetailsUseCase(private val repository: MovieRepository) {

    operator fun invoke(movieId: Int): Flow<Resource<Movie>> =
        repository.getMovieDetails(movieId)

}