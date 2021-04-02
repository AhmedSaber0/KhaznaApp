package com.khazna.data.local.datasource.keys

import com.khazna.data.local.entity.RemoteKeys

interface PostsKeysLocalDataSource {

    suspend fun insertAll(remoteKey: List<RemoteKeys>)

    suspend fun remoteKeysPostId(id: Int): RemoteKeys?

    suspend fun clearRemoteKeys()
}