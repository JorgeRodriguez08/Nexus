package com.example.nexus.domain.usecase.movies

import com.example.nexus.common.Resource
import com.example.nexus.domain.model.Movie
import com.example.nexus.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class SearchMoviesUseCase(private val repository: MovieRepository) {

    operator fun invoke(query: String, page: Int): Flow<Resource<List<Movie>>> =
        repository.searchMovies(query = query, page = page)

}