package com.example.nexus.domain.usecase

import com.example.nexus.domain.model.Movie
import com.example.nexus.utils.Resource
import kotlinx.coroutines.flow.Flow

interface GetMovieDetailsUseCase {
    operator fun invoke(movieId: Int): Flow<Resource<Movie>>
}