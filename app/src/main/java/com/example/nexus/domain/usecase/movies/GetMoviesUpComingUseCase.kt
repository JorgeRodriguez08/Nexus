package com.example.nexus.domain.usecase.movies

import com.example.nexus.common.Resource
import com.example.nexus.domain.model.Movie
import com.example.nexus.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class GetMoviesUpComingUseCase(private val repository: MovieRepository) {

    operator fun invoke(page: Int): Flow<Resource<List<Movie>>> =
        repository.getMoviesUpComing(page = page)

}