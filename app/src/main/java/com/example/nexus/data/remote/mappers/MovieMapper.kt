package com.example.nexus.data.remote.mappers

import com.example.nexus.BuildConfig
import com.example.nexus.data.remote.models.MovieDto
import com.example.nexus.domain.model.Movie

fun MovieDto.toDomainMovie(): Movie {
    return Movie(
        id = id,
        title = title.orEmpty(),
        overview = overview.orEmpty(),
        posterUrl = BuildConfig.TMDB_IMAGE_BASE_URL + posterPath.orEmpty(),
        backdropUrl = BuildConfig.TMDB_IMAGE_BASE_URL + backdropPath.orEmpty(),
        voteAverage = voteAverage ?: 0.0,
        releaseDate = releaseDate.orEmpty(),
        adult = adult ?: true
    )
}