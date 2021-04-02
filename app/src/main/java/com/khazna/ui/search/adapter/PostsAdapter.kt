package com.khazna.ui.search.adapter

import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.khazna.data.local.entity.PostModel

class PostsAdapter(private val listener: (View, PostModel, Int) -> Unit) :
    PagingDataAdapter<PostModel, PostViewHolder>(diffCallback) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PostViewHolder {
        return PostViewHolder.create(parent, listener)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) =
        holder.bind(getItem(position))

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<PostModel>() {
            override fun areItemsTheSame(
                oldItem: PostModel,
                newItem: PostModel
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: PostModel,
                newItem: PostModel
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}