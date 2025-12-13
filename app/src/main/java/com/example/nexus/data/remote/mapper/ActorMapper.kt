package com.example.nexus.data.remote.mapper

import com.example.nexus.data.remote.dto.ActorDto
import com.example.nexus.domain.model.Actor

fun ActorDto.toDomainActor(): Actor {
    return Actor(
        id = id,
        name = name.orEmpty()
    )
}