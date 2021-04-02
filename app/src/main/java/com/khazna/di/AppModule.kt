package com.khazna.di

import com.khazna.app.KhaznaApp
import org.koin.dsl.koinApplication
import org.koin.dsl.module

val appModule = module {

    koinApplication { KhaznaApp() }
}