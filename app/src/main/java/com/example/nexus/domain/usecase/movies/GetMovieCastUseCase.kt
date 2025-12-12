package com.example.nexus.domain.usecase.movies

import com.example.nexus.common.core.Resource
import com.example.nexus.domain.model.Actor
import com.example.nexus.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class GetMovieCastUseCase(private val repository: MovieRepository) {

    operator fun invoke(movieId: Int): Flow<Resource<List<Actor>>> =
        repository.getMovieCast(movieId = movieId)

}
