package com.example.nexus.di

import androidx.room.Room
import com.example.nexus.BuildConfig
import com.example.nexus.data.local.database.AppDatabase
import com.example.nexus.data.remote.ApiService
import com.example.nexus.common.constants.ApiConstants
import com.example.nexus.common.constants.NetworkConstants
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val appModule = module {

    single {
        val logging = HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
            else HttpLoggingInterceptor.Level.NONE
        }

        val headerInterceptor = Interceptor { chain ->
            val originalRequest = chain.request()
            val newRequest = originalRequest.newBuilder()
                .addHeader(ApiConstants.HEADER_ACCEPT, ApiConstants.HEADER_VALUE_APPLICATION_JSON)
                .addHeader(ApiConstants.HEADER_AUTHORIZATION, "Bearer ${BuildConfig.TMDB_BEARER_TOKEN}")
                .build()
            chain.proceed(newRequest)
        }

        OkHttpClient.Builder()
            .addInterceptor(headerInterceptor)
            .addInterceptor(logging)
            .connectTimeout(NetworkConstants.CONNECT_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .readTimeout(NetworkConstants.READ_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .build()
    }

    single {
        val gson = GsonBuilder().setLenient().create()
        Retrofit.Builder()
            .baseUrl(BuildConfig.TMDB_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(get())
            .build()
    }

    single {
        get<Retrofit>().create(ApiService::class.java)
    }

    single {
        Room.databaseBuilder(
            androidApplication(),
            AppDatabase::class.java,
            "nexus_database"
        ).build()
    }

    single { get<AppDatabase>().movieDao() }
    single { get<AppDatabase>().seriesDao() }
}