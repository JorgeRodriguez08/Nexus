package com.example.nexus.data.remote.mapper

import com.example.nexus.BuildConfig
import com.example.nexus.data.remote.dto.EpisodeDto
import com.example.nexus.domain.model.Episode

fun EpisodeDto.toDomainEpisode(): Episode {
    var stillUrl = ""
    if (stillPath != null && stillPath.isNotEmpty()) {
        stillUrl = BuildConfig.TMDB_IMAGE_BASE_URL + stillPath
    }

    return Episode(
        airDate = airDate.orEmpty(),
        episodeNumber = episodeNumber ?: 0,
        id = id ?: 0,
        name = name.orEmpty(),
        overview = overview.orEmpty(),
        runtime = runtime ?: 0,
        seasonNumber = seasonNumber ?: 0,
        stillUrl = stillUrl
    )
}