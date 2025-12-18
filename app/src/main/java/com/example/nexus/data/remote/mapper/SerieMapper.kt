package com.example.nexus.data.remote.mapper

import com.example.nexus.BuildConfig
import com.example.nexus.data.remote.dto.SerieDto
import com.example.nexus.domain.model.Serie

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
        adult = adult ?: true,
        posterUrl = posterUrl,
        backdropUrl = backdropUrl,
        voteAverage = voteAverage ?: 0.0,
        firstAirDate = firstAirDate.orEmpty()
    )
}