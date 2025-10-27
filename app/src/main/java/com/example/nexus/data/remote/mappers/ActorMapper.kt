package com.example.nexus.data.remote.mappers

import com.example.nexus.BuildConfig
import com.example.nexus.data.remote.models.ActorDto
import com.example.nexus.domain.model.Actor

fun ActorDto.toDomainActor(): Actor {
    return Actor(
        id = id,
        name = name.orEmpty(),
        profileUrl = BuildConfig.TMDB_IMAGE_BASE_URL + profilePath.orEmpty()
    )
}