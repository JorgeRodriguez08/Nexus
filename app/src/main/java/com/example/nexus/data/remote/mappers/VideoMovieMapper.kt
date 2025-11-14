package com.example.nexus.data.remote.mappers

import com.example.nexus.data.remote.models.VideoMovieDto
import com.example.nexus.domain.model.VideoMovie

fun VideoMovieDto.toDomainVideoMovie(): VideoMovie? {
    if (key == null || key.isEmpty()) {
        return null
    }
    if (name == null || name.isEmpty()) {
        return null
    }

    val finalId = id
    val finalName = name
    val finalKey = key
    val finalSite = site ?: ""
    val finalType = type ?: ""
    val finalOfficial = official ?: false

    return VideoMovie(
        id = finalId,
        name = finalName,
        key = finalKey,
        site = finalSite,
        type = finalType,
        official = finalOfficial
    )
}
