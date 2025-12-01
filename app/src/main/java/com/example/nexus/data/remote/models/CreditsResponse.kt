package com.example.nexus.data.remote.models

import com.google.gson.annotations.SerializedName

data class CreditsResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("cast")
    val cast: List<ActorDto>,
    @SerializedName("crew")
    val crew: List<ProducerDto>
)
