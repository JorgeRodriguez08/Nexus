package com.example.nexus.domain.usecase.movies

import com.example.nexus.common.Resource
import com.example.nexus.domain.models.Movie
import com.example.nexus.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow

class SearchMovieUseCase(private val repository: MoviesRepository) {
    operator fun invoke(query: String, page: Int): Flow<Resource<List<Movie>>> =
        repository.searchMovie(query, page)
}