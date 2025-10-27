package com.example.nexus.data.remote.mappers

import com.example.nexus.BuildConfig
import com.example.nexus.data.remote.models.ProducerDto
import com.example.nexus.domain.model.Producer

fun ProducerDto.toDomainProducer(): Producer {
    return Producer(
        id = id,
        name = name.orEmpty(),
        profileUrl = BuildConfig.TMDB_IMAGE_BASE_URL + profilePath.orEmpty(),
        job = job.orEmpty()
    )
}