package com.khazna.data.remote.post

import com.khazna.data.local.entity.PostModel
import retrofit2.http.GET

interface PostsApiService {

    @GET("posts")
    suspend fun getPosts(): List<PostModel>

}