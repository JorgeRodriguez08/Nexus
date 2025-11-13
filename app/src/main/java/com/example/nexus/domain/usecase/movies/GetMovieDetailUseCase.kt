package com.example.nexus.domain.usecase.movies

import com.example.nexus.common.Resource
import com.example.nexus.domain.model.MovieDetail
import com.example.nexus.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class GetMovieDetailUseCase(private val repository: MovieRepository) {

    operator fun invoke(movieId: Int): Flow<Resource<MovieDetail>> =
        repository.getMovieDetail(movieId = movieId)

}