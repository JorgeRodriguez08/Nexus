package com.example.nexus.domain.usecase.movies

import com.example.nexus.common.Resource
import com.example.nexus.domain.model.Producer
import com.example.nexus.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class GetMovieCrewUseCase(private val repository: MovieRepository) {

    operator fun invoke(movieId: Int): Flow<Resource<List<Producer>>> =
        repository.getMovieCrew(movieId = movieId)

}