package com.khazna.di

import androidx.room.Room
import com.khazna.common.KHAZNA_DB
import com.khazna.data.local.db.PostsDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(androidContext(), PostsDatabase::class.java, KHAZNA_DB)
            .fallbackToDestructiveMigration().build()
    }

    factory { get<PostsDatabase>().postsDao }
    factory { get<PostsDatabase>().remoteKeysDao }
}