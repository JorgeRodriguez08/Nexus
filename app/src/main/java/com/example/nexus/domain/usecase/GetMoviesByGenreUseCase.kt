package com.example.nexus.domain.usecase

import com.example.nexus.domain.model.Movie
import com.example.nexus.domain.repository.MovieRepository
import com.example.nexus.utils.Resource
import kotlinx.coroutines.flow.Flow

class GetMoviesByGenreUseCase(private val repository: MovieRepository) {

    operator fun invoke(genreId: Int, language: String? = null, page: Int): Flow<Resource<List<Movie>>> {
        return repository.getMovieByGenre(genreId, language, page)
    }

}