package com.khazna.data.repo.post

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.khazna.data.local.entity.PostModel
import kotlinx.coroutines.flow.Flow

interface PostsRepository {

    suspend fun getPosts(): List<PostModel>

    fun letPostsFlowDb(pagingConfig: PagingConfig) : Flow<PagingData<PostModel>>
}