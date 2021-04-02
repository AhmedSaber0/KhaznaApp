package com.khazna.di

import com.khazna.domain.usecase.post.PostsUseCase
import com.khazna.domain.usecase.post.PostsUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    factory<PostsUseCase> { PostsUseCaseImpl(postsRepository = get()) }
}