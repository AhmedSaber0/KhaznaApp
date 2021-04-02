package com.khazna.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.khazna.data.local.entity.PostModel

@Dao
interface PostsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savePostsList(postModels: List<PostModel>)

    @Query("SELECT * FROM posts")
    fun getPostsList(): PagingSource<Int, PostModel>

    @Query("DELETE FROM posts")
    suspend fun clearRemoteKeys()
}