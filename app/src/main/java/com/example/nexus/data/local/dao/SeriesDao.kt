package com.example.nexus.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import com.example.nexus.data.local.entity.SeriesEntity

@Dao
interface SeriesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSeries(series: SeriesEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllSeries(series: List<SeriesEntity>)

    @Query("SELECT * FROM series WHERE id = :seriesId")
    fun getSeriesById(seriesId: Int): Flow<SeriesEntity?>

    @Query("SELECT * FROM series ORDER BY timestamp DESC")
    fun getAllSeries(): Flow<List<SeriesEntity>>

    @Query("DELETE FROM series")
    suspend fun deleteAllSeries()
}