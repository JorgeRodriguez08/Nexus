package com.example.nexus.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ActorDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String?
)