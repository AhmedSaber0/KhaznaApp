package com.khazna.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RemoteKeys(@PrimaryKey val postId: Int, val prevKey: Int?, val nextKey: Int?)