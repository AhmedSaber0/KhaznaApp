package com.khazna.app

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.khazna.di.appModule
import com.khazna.di.viewModelModule
import com.khazna.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class KhaznaApp : Application() {

    override fun onCreate() {
        super.onCreate()


        startKoin {
            androidLogger()
            androidContext(this@KhaznaApp)
            modules(
                listOf(
                    appModule,
                    networkModule,
                    databaseModule,
                    repositoryModule,
                    dataSourceModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}