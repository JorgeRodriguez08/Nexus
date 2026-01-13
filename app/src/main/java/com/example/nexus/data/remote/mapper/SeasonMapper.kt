package com.example.nexus.data.remote.mapper

import com.example.nexus.BuildConfig
import com.example.nexus.data.remote.dto.SeasonDto
import com.example.nexus.domain.model.Season

fun SeasonDto.toDomainSeason(): Season {
    var posterUrl = ""
    if (posterPath != null && posterPath.isNotEmpty()) {
        posterUrl = BuildConfig.TMDB_IMAGE_BASE_URL + posterPath
    }

    return Season(
        airDate = airDate.orEmpty(),
        episodeCount = episodeCount ?: 0,
        id = id,
        name = name.orEmpty(),
        overview = overview.orEmpty(),
        posterUrl = posterUrl,
        seasonNumber = seasonNumber ?: 0
    )
}