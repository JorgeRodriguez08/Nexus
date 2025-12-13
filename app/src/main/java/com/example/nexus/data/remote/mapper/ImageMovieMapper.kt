package com.example.nexus.data.remote.mapper

import com.example.nexus.BuildConfig
import com.example.nexus.data.remote.dto.ImageMovieDto
import com.example.nexus.domain.model.ImageMovie

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