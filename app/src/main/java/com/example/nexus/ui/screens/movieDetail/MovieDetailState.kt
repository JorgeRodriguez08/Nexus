package com.example.nexus.ui.screens.movieDetail

import com.example.nexus.domain.model.Actor
import com.example.nexus.domain.model.ImageMovie
import com.example.nexus.domain.model.Movie
import com.example.nexus.domain.model.Producer
import com.example.nexus.domain.model.VideoMovie

sealed class MovieDetailState {
    object Loading : MovieDetailState()
    data class Success(val movie: Movie, val video: VideoMovie, val cast: List<Actor>, val crew: List<Producer>) : MovieDetailState()
    data class Error(val message: String) : MovieDetailState()
}