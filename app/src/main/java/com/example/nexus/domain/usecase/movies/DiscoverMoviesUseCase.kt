package com.example.nexus.domain.usecase.movies

import com.example.nexus.domain.models.Movie
import com.example.nexus.domain.repository.MoviesRepository
import com.example.nexus.common.Resource
import kotlinx.coroutines.flow.Flow

class DiscoverMoviesUseCase(private val repository: MoviesRepository) {
    operator fun invoke(genreId: String, page: Int, originCountry: String): Flow<Resource<List<Movie>>> =
        repository.discoverMovies(genreId, page, originCountry)
}