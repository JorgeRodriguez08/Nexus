package com.example.nexus.domain.usecase.movies

import com.example.nexus.common.Resource
import com.example.nexus.domain.models.ImageMovie
import com.example.nexus.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow

class GetMovieImageUseCase(private val repository: MoviesRepository) {
    operator fun invoke(movieId: Int): Flow<Resource<ImageMovie?>> =
        repository.getMovieImage(movieId = movieId)
}