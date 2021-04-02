package com.khazna.data.remote.post

import com.khazna.data.local.entity.PostModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PostsRemoteDataSourceImpl(private val apiService: PostsApiService) :
    PostsRemoteDataSource {

    override suspend fun getPosts(): List<PostModel> = withContext(Dispatchers.IO) {
        apiService.getPosts()
    }
}