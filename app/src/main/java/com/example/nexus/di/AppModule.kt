package com.example.nexus.di

import com.google.gson.GsonBuilder
import com.example.nexus.BuildConfig
import com.example.nexus.data.remote.ApiService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import androidx.room.Room
import com.example.nexus.data.local.database.AppDatabase
import org.koin.android.ext.koin.androidApplication

val appModule = module {

    // Provides OkHttpClient for networking
    single {

        val logging = HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }

        val headerInterceptor = Interceptor { chain ->
            val originalRequest = chain.request()
            val newRequest = originalRequest.newBuilder()
                .addHeader("Accept", "application/json")
                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI3NjVjMGRjYmVmOTQyZTMwODljMzM0ZjcxZWVkMjlmNSIsIm5iZiI6MTc0OTY5MDQ3MC4xMzQsInN1YiI6IjY4NGEyODY2OGNlNzI1MmYzNzlmNWQwYiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.lEdWvQ4YX5t0d16oNqFSvQkCZWGcdBn-6mPuKlV5d40")
                .build()
            chain.proceed(newRequest)
        }

        OkHttpClient.Builder()
            .addInterceptor(logging)
            .addInterceptor(headerInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    // Provides Retrofit instance
    single {
        val gson = GsonBuilder().setLenient().create()  // Use lenient GSON for flexible parsing
        Retrofit.Builder()
            .baseUrl(BuildConfig.TMDB_BASE_URL)  // Base URL from BuildConfig
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(get()) // Inject OkHttpClient
            .build()
    }

    // Provides ApiService using Retrofit
    single {
        get<Retrofit>().create(ApiService::class.java)
    }

    // Room Database
    single {
        Room.databaseBuilder(
            androidApplication(),
            AppDatabase::class.java,
            "nexus_database"
        )
            .build()
    }

    single { get<AppDatabase>().movieDao() }

    single { get<AppDatabase>().seriesDao() }

}