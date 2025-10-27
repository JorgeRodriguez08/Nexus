package com.example.nexus.data.remote.models

data class CreditsResponse(
    val id: Int,
    val cast: List<ActorDto>,
    val crew: List<ProducerDto>
)
