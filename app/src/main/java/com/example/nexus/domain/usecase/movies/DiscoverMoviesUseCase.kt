package com.example.nexus.domain.usecase.movies

import com.example.nexus.domain.model.Movie
import com.example.nexus.domain.repository.movies.MoviesRepository
import com.example.nexus.common.core.Resource
import kotlinx.coroutines.flow.Flow

class DiscoverMoviesUseCase(private val repository: MoviesRepository) {
    operator fun invoke(genreId: String, page: Int, originCountry: String): Flow<Resource<List<Movie>>> =
        repository.discoverMovies(genreId, page, originCountry)
}