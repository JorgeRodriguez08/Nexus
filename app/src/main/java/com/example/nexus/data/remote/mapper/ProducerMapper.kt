package com.example.nexus.data.remote.mapper

import com.example.nexus.data.remote.dto.ProducerDto
import com.example.nexus.domain.model.Producer

fun ProducerDto.toDomainProducer(): Producer {
    return Producer(
        id = id,
        name = name.orEmpty(),
        job = job.orEmpty()
    )
}