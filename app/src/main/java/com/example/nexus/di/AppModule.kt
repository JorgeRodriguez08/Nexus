package com.example.nexus.di

import com.google.gson.GsonBuilder
import com.example.nexus.BuildConfig
import com.example.nexus.data.remote.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val appModule = module {

    // Provides OkHttpClient for networking
    single {

        val logging = HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }

        OkHttpClient.Builder()
            .addInterceptor(logging)
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
}