package com.example.nexus.data.remote.models

import com.google.gson.annotations.SerializedName

data class SeriesResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<SeriesDto>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)