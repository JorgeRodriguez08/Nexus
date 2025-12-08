package com.example.nexus.data.remote.mappers

import com.example.nexus.data.remote.models.ActorDto
import com.example.nexus.domain.models.Actor

fun ActorDto.toDomainActor(): Actor {
    return Actor(
        id = id,
        name = name.orEmpty()
    )
}