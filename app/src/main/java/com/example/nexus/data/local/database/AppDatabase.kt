package com.example.nexus.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.nexus.data.local.entities.MovieEntity
import com.example.nexus.data.local.entities.SeriesEntity
import com.example.nexus.data.local.dao.MovieDao
import com.example.nexus.data.local.dao.SeriesDao

@Database(
    entities = [MovieEntity::class, SeriesEntity::class],
    version = 1,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao

    abstract fun seriesDao(): SeriesDao
}