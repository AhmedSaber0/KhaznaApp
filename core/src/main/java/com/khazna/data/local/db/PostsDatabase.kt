package com.khazna.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.khazna.common.KHAZNA_DB
import com.khazna.data.local.dao.PostsDao
import com.khazna.data.local.dao.RemoteKeysDao
import com.khazna.data.local.entity.PostModel
import com.khazna.data.local.entity.RemoteKeys


@Database(entities = [PostModel::class, RemoteKeys::class],version = 1,exportSchema = false)
abstract class PostsDatabase : RoomDatabase(){

    abstract val postsDao : PostsDao

    abstract val remoteKeysDao : RemoteKeysDao
}