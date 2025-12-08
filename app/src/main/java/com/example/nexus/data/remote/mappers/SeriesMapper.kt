package com.example.nexus.data.remote.mappers

import com.example.nexus.BuildConfig
import com.example.nexus.data.remote.models.SerieDto
import com.example.nexus.domain.models.Serie

fun SerieDto.toDomainSerie(): Serie {
    var posterUrl = ""
    if (posterPath != null && posterPath.isNotEmpty()) {
        posterUrl = BuildConfig.TMDB_IMAGE_BASE_URL + posterPath
    }
    var backdropUrl = ""
    if (backdropPath != null && backdropPath.isNotEmpty()) {
        backdropUrl = BuildConfig.TMDB_IMAGE_BASE_URL + backdropPath
    }

    return Serie(
        id = id,
        title = title.orEmpty(),
        overview = overview.orEmpty(),
        posterUrl = posterUrl,
        backdropUrl = backdropUrl,
        voteAverage = voteAverage ?: 0.0,
        firstAirDate = firstAirDate.orEmpty()
    )
}