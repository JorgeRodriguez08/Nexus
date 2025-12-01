package com.example.nexus.data.remote.models

import com.google.gson.annotations.SerializedName

data class VideosMovieResponse(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("results")
    val results: List<VideoMovieDto>?
)

