package com.example.nexus.domain.usecase.movies

import com.example.nexus.domain.model.Movie
import com.example.nexus.domain.repository.MovieRepository
import com.example.nexus.common.Resource
import kotlinx.coroutines.flow.Flow

class GetMoviesByGenreUseCase(private val repository: MovieRepository) {

    operator fun invoke(genreId: Int, page: Int): Flow<Resource<List<Movie>>> =
        repository.getMoviesByGenre(genreId, page)

}