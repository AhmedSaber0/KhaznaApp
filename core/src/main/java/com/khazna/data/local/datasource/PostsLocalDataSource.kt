package com.khazna.data.local.datasource

import androidx.paging.PagingSource
import com.khazna.data.local.entity.PostModel

interface PostsLocalDataSource {

    suspend fun savePostsList(postModels: List<PostModel>)

    fun getPostsList() : PagingSource<Int, PostModel>

    suspend fun clearRemoteKeys()

}