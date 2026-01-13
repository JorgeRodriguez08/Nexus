package com.example.nexus.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ImagesSeriesResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("logos")
    val logos: List<ImageSerieDto>
)