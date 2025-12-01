package com.example.nexus.data.remote.models

import com.google.gson.annotations.SerializedName

data class ProducerDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String?,
    @SerializedName("profile_path")
    val profilePath: String?,
    @SerializedName("job")
    val job: String?
)
