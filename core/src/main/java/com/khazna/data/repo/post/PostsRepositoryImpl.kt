package com.khazna.data.repo.post

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.khazna.data.local.datasource.PostsLocalDataSource
import com.khazna.data.local.datasource.keys.PostsKeysLocalDataSource
import com.khazna.data.local.db.PostsDatabase
import com.khazna.data.local.entity.PostModel
import com.khazna.data.remote.post.PostsRemoteDataSource
import kotlinx.coroutines.flow.Flow

class PostsRepositoryImpl(
    private val remoteDataSource: PostsRemoteDataSource,
    private val postsKeysLocalDataSource: PostsKeysLocalDataSource,
    private val postsLocalDataSource: PostsLocalDataSource,
    private val postsDatabase: PostsDatabase
) : PostsRepository {

    @ExperimentalPagingApi
   override fun letPostsFlowDb(pagingConfig: PagingConfig): Flow<PagingData<PostModel>> {
        val pagingSourceFactory = { postsLocalDataSource.getPostsList() }
        return Pager(
            config = pagingConfig,
            pagingSourceFactory = pagingSourceFactory,
            remoteMediator = PostsMediator(
                remoteDataSource,
                postsKeysLocalDataSource,
                postsLocalDataSource,
                postsDatabase
            )
        ).flow
    }

    override suspend fun getPosts(): List<PostModel> =
        remoteDataSource.getPosts()
}