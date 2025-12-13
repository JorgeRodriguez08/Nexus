package com.example.nexus.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ProducerDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String?,
    @SerializedName("job")
    val job: String?
)