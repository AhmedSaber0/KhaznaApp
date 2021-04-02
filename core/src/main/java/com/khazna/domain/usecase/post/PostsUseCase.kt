package com.khazna.domain.usecase.post

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.khazna.data.local.entity.PostModel
import kotlinx.coroutines.flow.Flow

interface PostsUseCase {

    suspend fun getPosts(): List<PostModel>

    fun letPostsFlowDb(pagingConfig: PagingConfig) : Flow<PagingData<PostModel>>
}