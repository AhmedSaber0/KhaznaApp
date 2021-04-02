package com.khazna.data.remote.post

import com.khazna.data.local.entity.PostModel

interface PostsRemoteDataSource {

    suspend fun getPosts(): List<PostModel>

}