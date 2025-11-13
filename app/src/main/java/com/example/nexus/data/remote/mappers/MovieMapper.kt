package com.example.nexus.data.remote.mappers

import com.example.nexus.BuildConfig
import com.example.nexus.data.remote.models.MovieDto
import com.example.nexus.domain.model.Movie

fun MovieDto.toDomainMovie(): Movie {
    return Movie(
        id = id,
        title = title ?: DEFAULT_TITLE,
        overview = overview ?: DEFAULT_OVERVIEW,
        adult = adult ?: DEFAULT_ADULT,
        posterUrl = BuildConfig.TMDB_IMAGE_BASE_URL + (posterPath ?: DEFAULT_POSTER_PATH),
        backdropUrl = BuildConfig.TMDB_IMAGE_BASE_URL + (backdropPath ?: DEFAULT_BACKDROP_PATH),
        voteAverage = voteAverage ?: DEFAULT_VOTE,
        releaseDate = releaseDate ?: DEFAULT_RELEASE_DATE,
        runtime = runtime ?: DEFAULT_RUNTIME
    )
}

private const val DEFAULT_TITLE = "Untitled"
private const val DEFAULT_OVERVIEW = "No overview available."
private const val DEFAULT_ADULT = true
private const val DEFAULT_POSTER_PATH = "/chpWmskl3aKm1aTZqUHRCtviwPy.jpg"
private const val DEFAULT_BACKDROP_PATH = "/2OvpmWYrsv8eMyV3AAqhoMnzMF.jpg"
private const val DEFAULT_VOTE = 0.0
private const val DEFAULT_RELEASE_DATE = "Unknown"
private const val DEFAULT_RUNTIME = 0


