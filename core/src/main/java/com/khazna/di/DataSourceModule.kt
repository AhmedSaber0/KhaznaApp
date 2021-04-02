package com.khazna.di

import com.khazna.data.local.datasource.PostsLocalDataSource
import com.khazna.data.local.datasource.PostsLocalDataSourceImpl
import com.khazna.data.local.datasource.keys.PostsKeysLocalDataSource
import com.khazna.data.local.datasource.keys.PostsKeysLocalDataSourceImpl
import com.khazna.data.remote.post.PostsRemoteDataSource
import com.khazna.data.remote.post.PostsRemoteDataSourceImpl
import org.koin.dsl.module

val dataSourceModule = module {
    factory<PostsRemoteDataSource> { PostsRemoteDataSourceImpl(apiService = get()) }
    factory<PostsLocalDataSource> { PostsLocalDataSourceImpl(postsDao = get()) }
    factory<PostsKeysLocalDataSource> { PostsKeysLocalDataSourceImpl(remoteKeysDao = get()) }
}