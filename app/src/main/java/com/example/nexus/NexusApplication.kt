package com.example.nexus

import android.app.Application
import com.example.nexus.di.appModule
import com.example.nexus.di.dataModule
import com.example.nexus.di.moviesDomainModule
import com.example.nexus.di.seriesDomainModule
import com.example.nexus.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class NexusApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@NexusApplication)
            modules(
                appModule,
                dataModule,
                moviesDomainModule,
                seriesDomainModule,
                viewModelModule
            )
        }
    }
}