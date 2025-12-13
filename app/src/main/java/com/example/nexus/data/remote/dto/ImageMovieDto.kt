package com.example.nexus.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ImageMovieDto(
    @SerializedName("aspect_ratio")
    val aspectRatio: Double?,
    @SerializedName("height")
    val height: Int?,
    @SerializedName("file_path")
    val filePath: String?,
    @SerializedName("width")
    val width: Int?
)