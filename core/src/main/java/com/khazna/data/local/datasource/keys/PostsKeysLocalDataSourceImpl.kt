package com.khazna.data.local.datasource.keys

import com.khazna.data.local.dao.RemoteKeysDao
import com.khazna.data.local.entity.RemoteKeys
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PostsKeysLocalDataSourceImpl(private val remoteKeysDao: RemoteKeysDao) :
    PostsKeysLocalDataSource {
    override suspend fun insertAll(remoteKey: List<RemoteKeys>) = withContext(Dispatchers.IO) {
        remoteKeysDao.insertAll(remoteKey)
    }

    override suspend fun remoteKeysPostId(id: Int): RemoteKeys? = withContext(Dispatchers.IO) {
        remoteKeysDao.remoteKeysPostId(id)
    }

    override suspend fun clearRemoteKeys() = withContext(Dispatchers.IO) {
        remoteKeysDao.clearRemoteKeys()
    }
}