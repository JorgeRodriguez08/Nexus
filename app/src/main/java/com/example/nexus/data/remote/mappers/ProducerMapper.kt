package com.example.nexus.data.remote.mappers

import com.example.nexus.data.remote.models.ProducerDto
import com.example.nexus.domain.models.Producer

fun ProducerDto.toDomainProducer(): Producer {
    return Producer(
        id = id,
        name = name.orEmpty(),
        job = job.orEmpty()
    )
}