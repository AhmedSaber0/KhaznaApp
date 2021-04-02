package com.khazna.data.local.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "posts")
data class PostModel(
    @PrimaryKey
    val id: Int,
    val userId: Int,
    val title: String,
    val body: String
) : Parcelable
