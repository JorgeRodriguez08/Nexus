package com.example.nexus.domain.usecase.movies

import com.example.nexus.common.Resource
import com.example.nexus.domain.models.MovieDetails
import com.example.nexus.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow

class GetMovieDetailsUseCase(private val repository: MoviesRepository) {
    operator fun invoke(movieId: Int): Flow<Resource<MovieDetails>> =
        repository.getMovieDetails(movieId)
}