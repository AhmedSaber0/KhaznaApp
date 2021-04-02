package com.khazna.data.local.datasource

import androidx.paging.PagingSource
import com.khazna.data.local.dao.PostsDao
import com.khazna.data.local.entity.PostModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PostsLocalDataSourceImpl(private val postsDao: PostsDao) :
    PostsLocalDataSource {

    override suspend fun savePostsList(postModels: List<PostModel>) =
        withContext(Dispatchers.IO) {
            postsDao.savePostsList(postModels)
        }

    override fun getPostsList(): PagingSource<Int, PostModel> =
        postsDao.getPostsList()

    override suspend fun clearRemoteKeys() = withContext(Dispatchers.IO) {
        postsDao.clearRemoteKeys()
    }
}