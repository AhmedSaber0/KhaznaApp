package com.khazna.ui.search.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.khazna.R
import com.khazna.data.local.entity.PostModel
import com.khazna.databinding.LayoutPostItemBinding

class PostViewHolder(
    private val binding: LayoutPostItemBinding,
    private val listener: (View, PostModel, Int) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(postModel : PostModel?) {
        postModel?.let {
            binding.titleTxv.text = it.title
            binding.bodyTxv.text = it.body
            itemView.setOnClickListener {
                listener.invoke(it, postModel, adapterPosition)
            }
        }
    }


    companion object {
        fun create(parent: ViewGroup, listener: (View, PostModel, Int) -> Unit): PostViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_post_item, parent, false)
            val binding = LayoutPostItemBinding.bind(view)
            return PostViewHolder(binding, listener)
        }
    }
}