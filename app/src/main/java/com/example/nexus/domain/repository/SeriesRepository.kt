package com.example.nexus.domain.repository

import com.example.nexus.domain.model.Series
import com.example.nexus.untils.Resource

interface SeriesRepository {

    suspend fun getPopularSeries(page: Int): Resource<List<Series>>

    suspend fun getSeriesDetails(seriesId: Int): Resource<Series>

    suspend fun searchSeries(query: String, page: Int): Resource<List<Series>>

}