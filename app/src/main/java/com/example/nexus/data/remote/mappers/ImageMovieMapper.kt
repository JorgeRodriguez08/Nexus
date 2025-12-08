package com.example.nexus.data.remote.mappers

import com.example.nexus.BuildConfig
import com.example.nexus.data.remote.models.ImageMovieDto
import com.example.nexus.domain.models.ImageMovie

fun ImageMovieDto.toDomainImageMovie(): ImageMovie {
    var fileUrl = ""
    if (filePath != null && filePath.isNotEmpty()) {
        fileUrl = BuildConfig.TMDB_IMAGE_BASE_URL + filePath
    }

    return ImageMovie(
        aspectRatio = aspectRatio ?: 0.0,
        height = height ?: 0,
        width = width ?: 0,
        fileUrl = fileUrl
    )
}