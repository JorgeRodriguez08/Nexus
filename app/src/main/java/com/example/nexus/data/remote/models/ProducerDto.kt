package com.example.nexus.data.remote.models

import com.google.gson.annotations.SerializedName

data class ProducerDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String?,
    @SerializedName("job")
    val job: String?
)
