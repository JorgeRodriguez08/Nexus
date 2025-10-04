//package com.example.nexus.ui.screens.movieDetail.preview
//
//import android.content.res.Configuration
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Scaffold
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import com.example.nexus.domain.model.Movie
//import com.example.nexus.domain.model.Video
//import com.example.nexus.ui.screens.movieDetail.MovieDetailCard
//import com.example.nexus.ui.theme.NexusTheme
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun MovieDetailLayout(
//    modifier: Modifier = Modifier
//) {
//    NexusTheme {
//        Scaffold(
//            topBar = { },
//            bottomBar = { }
//        ) { innerPadding ->
//            val movie = Movie(
//                id = 1,
//                title = "Rescate imposible",
//                overview = "Tras una operación fallida, un soldado queda atrapado en territorio enemigo."
//                        + " Su única esperanza para volver a casa es un lejano piloto de dron.",
//                posterUrl = "https://image.tmdb.org/t/p/w500/qmDpIHrmpJINaRKAfWQfftjCdyi.jpg",
//                backdropUrl = "https://image.tmdb.org/t/p/w500/s3TBrRGB1iav7gFOCNx3H31MoES.jpg",
//                voteAverage = 8.3,
//                releaseDate = "2025-09-18",
//                adult = true
//            )
//
//            val video = Video(
//                id = "1",
//                name = "Rescate imposible - Trailer",
//                key = "L6P3nI6VnlY",
//                site = "YouTube",
//                type = "Trailer",
//                official = true
//            )
//
//            MovieDetailCard(
//                movie = movie,
//                video = video,
//                modifier = modifier.padding(innerPadding)
//            )
//        }
//    }
//}
//
//@Preview (showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
//@Composable
//fun MovieDetailPreview() {
//    MovieDetailLayout(modifier = Modifier)
//}