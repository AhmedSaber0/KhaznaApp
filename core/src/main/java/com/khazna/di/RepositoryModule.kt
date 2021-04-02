package com.khazna.di

import com.khazna.data.repo.post.PostsRepository
import com.khazna.data.repo.post.PostsRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    factory<PostsRepository> {
        PostsRepositoryImpl(
            remoteDataSource = get(),
            postsLocalDataSource = get(),
            postsKeysLocalDataSource = get(),
            postsDatabase = get()
        )
    }
}