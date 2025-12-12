package com.example.nexus.domain.repository

import com.example.nexus.domain.model.Series
import com.example.nexus.common.core.Resource
import kotlinx.coroutines.flow.Flow

interface SeriesRepository {

    fun getSeriesAiringToday(page: Int): Flow<Resource<List<Series>>>

    fun getSeriesOnTheAir(page: Int): Flow<Resource<List<Series>>>

    fun getSeriesPopular(page: Int): Flow<Resource<List<Series>>>

    fun getSeriesTopRated(page: Int): Flow<Resource<List<Series>>>

    fun getSeriesByGenre(genreId: String, page: Int): Flow<Resource<List<Series>>>

    fun getSeriesById(seriesId: Int): Flow<Resource<Series>>

    fun searchSeries(query: String, page: Int): Flow<Resource<List<Series>>>

}
