package com.example.nexus.domain.usecase.movies

import com.example.nexus.common.core.Resource
import com.example.nexus.domain.model.ImageMovie
import com.example.nexus.domain.repository.movies.MoviesRepository
import kotlinx.coroutines.flow.Flow

class GetMovieImageUseCase(private val repository: MoviesRepository) {
    operator fun invoke(movieId: Int): Flow<Resource<ImageMovie?>> =
        repository.getMovieImage(movieId = movieId)
}