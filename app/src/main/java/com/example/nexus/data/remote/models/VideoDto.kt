package com.example.nexus.data.remote.models

data class VideoDto(
    val id: String,
    val name: String,
    val key: String,
    val site: String,
    val type: String,
    val official: Boolean = true
)
