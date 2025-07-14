package com.example.nexus.domain.repository

import com.example.nexus.domain.model.Series
import com.example.nexus.utils.Resource
import kotlinx.coroutines.flow.Flow

interface SeriesRepository {

    fun getSeries(page: Int): Flow<Resource<List<Series>>>

    fun getSeriesById(seriesId: Int): Flow<Resource<Series>>

    fun searchSeries(query: String, page: Int): Flow<Resource<List<Series>>>

    fun getSeriesByGenre(genreId: Int, language: String, page: Int): Flow<Resource<List<Series>>>

}
