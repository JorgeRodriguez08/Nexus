package com.example.nexus.domain.usecase

import com.example.nexus.domain.repository.MovieRepository
import com.example.nexus.domain.model.Movie
import com.example.nexus.utils.Resource
import kotlinx.coroutines.flow.Flow

class GetMoviesUseCase(private val repository: MovieRepository)  {

    operator fun invoke(page: Int): Flow<Resource<List<Movie>>> {
        return repository.getMovies(page = page)
    }

}