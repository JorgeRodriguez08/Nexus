package com.example.nexus.domain.usecase.movies

import com.example.nexus.common.core.Resource
import com.example.nexus.domain.model.MovieMultimedia
import com.example.nexus.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class GetMovieMultimediaUseCase(private val repository: MovieRepository) {

    operator fun invoke(movieId: Int): Flow<Resource<MovieMultimedia>> =
        repository.getMovieMultimedia(movieId = movieId)

}