package com.example.nexus.data.remote.mappers

import com.example.nexus.BuildConfig
import com.example.nexus.data.remote.models.ImageMovieDto
import com.example.nexus.domain.model.ImageMovie

fun ImageMovieDto.toDomainImageMovie(): ImageMovie? {
    if (filePath == null || filePath.isEmpty()) {
        return null
    }

    val finalAspectRatio = aspectRatio ?: 0.0
    val finalHeight = height ?: 0
    val finalWidth = width ?: 0
    val finalFileUrl = BuildConfig.TMDB_IMAGE_BASE_URL + filePath

    return ImageMovie(
        aspectRatio = finalAspectRatio,
        height = finalHeight,
        width = finalWidth,
        fileUrl = finalFileUrl
    )
}