package com.khazna.di

import com.khazna.ui.search.PostsViewModel
import com.khazna.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SplashViewModel() }
    viewModel { PostsViewModel(useCase = get()) }
}