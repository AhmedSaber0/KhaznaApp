package com.khazna.domain.usecase.post

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.khazna.data.local.entity.PostModel
import com.khazna.data.repo.post.PostsRepository
import kotlinx.coroutines.flow.Flow

class PostsUseCaseImpl(private val postsRepository: PostsRepository) : PostsUseCase {

    override suspend fun getPosts(): List<PostModel> = postsRepository.getPosts()

    override fun letPostsFlowDb(pagingConfig: PagingConfig): Flow<PagingData<PostModel>> =
        postsRepository.letPostsFlowDb(pagingConfig = pagingConfig)
}