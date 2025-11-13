package com.example.nexus.domain.usecase.movies

import com.example.nexus.common.Resource
import com.example.nexus.domain.model.ImageMovie
import com.example.nexus.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class GetMovieImageUseCase(private val repository: MovieRepository) {

    operator fun invoke(movieId: Int): Flow<Resource<ImageMovie>> =
        repository.getMovieImages(movieId = movieId)

}