package com.example.nexus

import android.app.Application
import com.example.nexus.di.appModule
import com.example.nexus.di.dataModule
import com.example.nexus.di.domainModule
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
                domainModule,
                viewModelModule
            )
        }
    }
}