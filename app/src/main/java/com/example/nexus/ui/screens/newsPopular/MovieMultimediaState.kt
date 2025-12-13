package com.example.nexus.ui.screens.newsPopular

import com.example.nexus.domain.model.ImageMovie

sealed class MovieMultimediaState {

    object Loading : MovieMultimediaState()
    data class Success(val data: ImageMovie?) : MovieMultimediaState()
    data class Error(val message: String) : MovieMultimediaState()

}