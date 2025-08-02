//package com.example.nexus.ui.screen.home
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.nexus.domain.model.Movie
//import com.example.nexus.domain.model.Series
//import com.example.nexus.domain.usecase.GetMoviesByGenreUseCase
//import com.example.nexus.domain.usecase.GetMoviesPopularUseCase
//import com.example.nexus.domain.usecase.GetSeriesByGenreUseCase
//import com.example.nexus.domain.usecase.GetSeriesPopularUseCase
//import com.example.nexus.utils.Resource
//import kotlinx.coroutines.flow.Flow
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.flow.asStateFlow
//import kotlinx.coroutines.flow.update
//import kotlinx.coroutines.launch
//
//class HomeViewModel(
//    private val getMoviesPopularUseCase: GetMoviesPopularUseCase,
//    private val getMoviesByGenreUseCase: GetMoviesByGenreUseCase,
//
//    private val getSeriesPopularUseCase: GetSeriesPopularUseCase,
//    private val getSeriesByGenreUseCase: GetSeriesByGenreUseCase,
//) : ViewModel() {
//
//    private val _uiState = MutableStateFlow(HomeUiState())
//    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()
//
//    private val _featuredMovie = MutableStateFlow<Movie?>(null)
//    val featuredMovie: StateFlow<Movie?> = _featuredMovie.asStateFlow()
//
//    init {
//        loadHomeContent()
//    }
//
//    private fun loadHomeContent() {
//    homeCategories.forEach { category ->
//           if (category.isMovie) {
//               val fetchMovie: suspend () -> Flow<Resource<List<Movie>>> = {
//                   category.genreId?.let { getMoviesByGenreUseCase(it, 1) }
//                       ?: getMoviesPopularUseCase(1)
//               }
//               loadMovieCategory(category, fetchMovie)
//           } else if (category.isSeries) {
//                val fetchSeries: suspend () -> Flow<Resource<List<Series>>> = {
//                    category.genreId?.let { getSeriesByGenreUseCase(it, 1) }
//                        ?: getSeriesPopularUseCase(1)
//                }
//               loadSeriesCategory(category, fetchSeries)
//           }
//
//
//        }
//    }
//
//    private fun loadMovieCategory(
//        category: HomeCategory,
//        fetch: suspend () -> Flow<Resource<List<Movie>>>
//    ) {
//        viewModelScope.launch {
//            fetch().collect { result ->
//                val currentMap = _uiState.value.movieState.toMutableMap()
//                currentMap[category] = when (result) {
//                    is Resource.Loading -> CategoryUiState(isLoading = true)
//                    is Resource.Success -> {
//                        val items = result.data ?: emptyList()
//                        if (_featuredMovie.value == null && items.isNotEmpty()) {
//                            _featuredMovie.value = items.first()
//                        }
//                        CategoryUiState(items = items)
//                    }
//                    is Resource.Error -> CategoryUiState(error = result.message)
//                }
//                _uiState.update { it.copy(movieState = currentMap) }
//            }
//        }
//    }
//
//    private fun loadSeriesCategory(
//        category: HomeCategory,
//        fetch: suspend () -> Flow<Resource<List<Series>>>
//    ) {
//        viewModelScope.launch {
//            fetch().collect { result ->
//                val currentMap = _uiState.value.seriesState.toMutableMap()
//                currentMap[category] = when (result) {
//                    is Resource.Loading -> CategoryUiState(isLoading = true)
//                    is Resource.Success -> CategoryUiState(items = result.data ?: emptyList())
//                    is Resource.Error -> CategoryUiState(error = result.message)
//                }
//                _uiState.update { it.copy(seriesState = currentMap) }
//            }
//        }
//    }
//
//}
//
