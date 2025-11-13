package com.example.nexus.data.remote.mappers

import com.example.nexus.BuildConfig
import com.example.nexus.data.remote.models.ImageMovieDto
import com.example.nexus.domain.model.ImageMovie

fun ImageMovieDto.toDomainImageMovie(): ImageMovie {
    return ImageMovie(
        aspectRatio = aspectRatio ?: DEFAULT_ASPECT_RATIO,
        height = height ?: DEFAULT_HEIGHT,
        width = width ?: DEFAULT_WIDTH,
        fileUrl = BuildConfig.TMDB_IMAGE_BASE_URL + (filePath ?: DEFAULT_FILE_PATH)
    )
}

const val DEFAULT_ASPECT_RATIO = 3.778
const val DEFAULT_HEIGHT = 1439
const val DEFAULT_WIDTH = 5436
const val DEFAULT_FILE_PATH = "/s6mjieZwLWGsZMWPzgpHIaufuw8.png"

val imageDefault: ImageMovie = ImageMovie(
    aspectRatio = DEFAULT_ASPECT_RATIO,
    height = DEFAULT_HEIGHT,
    width = DEFAULT_WIDTH,
    fileUrl = BuildConfig.TMDB_IMAGE_BASE_URL + DEFAULT_FILE_PATH
)