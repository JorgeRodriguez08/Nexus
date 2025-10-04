package com.example.nexus.data.remote.mappers

import com.example.nexus.data.remote.models.VideoDto
import com.example.nexus.domain.model.Video

fun VideoDto.toDomainVideo(): Video {
    return Video(
        id = id,
        name = name,
        key = key,
        site = site,
        type = type,
        official = official
    )
}
