package com.example.nexus.data.remote.mappers

import com.example.nexus.data.remote.models.VideoMovieDto
import com.example.nexus.domain.model.VideoMovie

fun VideoMovieDto.toDomainVideoMovie(): VideoMovie {
    return VideoMovie(
        id = id,
        name = name ?: DEFAULT_NAME,
        key = key ?: DEFAULT_KEY,
        site = site ?: DEFAULT_SITE,
        type = type ?: DEFAULT_TYPE,
        official = official ?: DEFAULT_OFFICIAL
    )
}

private const val DEFAULT_ID = "6911e7e5eacffe65b23a3238"
private const val DEFAULT_NAME = "How TRON: ARES Writer Jesse Wigutow Approaches Screenwriting"
private const val DEFAULT_KEY = "kyotjgdBWB0"
private const val DEFAULT_SITE = "YouTube"
private const val DEFAULT_TYPE = "Featurette"
private const val DEFAULT_OFFICIAL = true

val videoDefault: VideoMovie = VideoMovie(
    id = DEFAULT_ID,
    name = DEFAULT_NAME,
    key = DEFAULT_KEY,
    site = DEFAULT_SITE,
    type = DEFAULT_TYPE,
    official = DEFAULT_OFFICIAL
)
