package com.example.nexus.data.remote.mapper

import com.example.nexus.BuildConfig
import com.example.nexus.data.remote.dto.ImageMovieDto
import com.example.nexus.data.remote.dto.ImageSerieDto
import com.example.nexus.domain.model.ImageMovie
import com.example.nexus.domain.model.ImageSerie

fun ImageSerieDto.toDomainImageSerie(): ImageSerie {
    var fileUrl = ""
    if (filePath != null && filePath.isNotEmpty()) {
        fileUrl = BuildConfig.TMDB_IMAGE_BASE_URL + filePath
    } else {
        fileUrl
    }

    return ImageSerie(
        aspectRatio = aspectRatio ?: 0.0,
        height = height ?: 0,
        width = width ?: 0,
        fileUrl = fileUrl
    )
}