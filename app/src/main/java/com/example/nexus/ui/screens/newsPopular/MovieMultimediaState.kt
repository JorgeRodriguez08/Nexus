package com.example.nexus.ui.screens.newsPopular

import com.example.nexus.domain.models.MovieMultimedia

sealed class MovieMultimediaState {

    object Loading : MovieMultimediaState()
    data class Success(val data: MovieMultimedia) : MovieMultimediaState()
    data class Error(val message: String) : MovieMultimediaState()

}