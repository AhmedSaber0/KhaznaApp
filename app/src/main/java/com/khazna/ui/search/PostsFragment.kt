package com.khazna.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import com.khazna.base.BaseFragment
import com.khazna.databinding.FragmentPostsBinding
import com.khazna.ui.search.adapter.LoaderStateAdapter
import com.khazna.ui.search.adapter.PostsAdapter
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class PostsFragment : BaseFragment<FragmentPostsBinding, PostsViewModel>() {

    private lateinit var loaderStateAdapter: LoaderStateAdapter
    private lateinit var postsAdapter: PostsAdapter

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        attachToParent: Boolean
    ): FragmentPostsBinding = FragmentPostsBinding.inflate(inflater, container, attachToParent)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        setupObservers()
        setupRecyclerView()
        viewModel.fetchPosts.value = true
    }

    private fun setupObservers() {
        viewModel.getPosts().observe(viewLifecycleOwner, {
            lifecycleScope.launch {
                postsAdapter.submitData(it)
            }
        })
    }

    private fun setupRecyclerView() {
        postsAdapter = PostsAdapter { view, item, i ->
            navigateWithAction(
                PostsFragmentDirections.actionPostsFragmentToDetailsFragment(
                    item
                )
            )
        }
        loaderStateAdapter = LoaderStateAdapter { postsAdapter.retry() }
        binding.recyclerview.adapter = postsAdapter.withLoadStateHeaderAndFooter(
            header = LoaderStateAdapter { postsAdapter.retry() },
            footer = LoaderStateAdapter { postsAdapter.retry() })
        postsAdapter.addLoadStateListener { loadState ->
            val isListEmpty =
                loadState.refresh is LoadState.NotLoading && postsAdapter.itemCount == 0
            showEmptyList(isListEmpty)

            binding.recyclerview.isVisible = loadState.source.refresh is LoadState.NotLoading

            binding.progressBar.isVisible = loadState.source.refresh is LoadState.Loading

            binding.retryButton.isVisible = loadState.source.refresh is LoadState.Error

            val errorState = loadState.source.append as? LoadState.Error
                ?: loadState.source.prepend as? LoadState.Error
                ?: loadState.append as? LoadState.Error
                ?: loadState.prepend as? LoadState.Error

            errorState?.let {
                showLongToast("\uD83D\uDE28 Wooops ${it.error}")
            }
        }
    }

    private fun initViews() {
        binding.swipeRefreshLayout.setOnRefreshListener {
            binding.swipeRefreshLayout.isRefreshing = false
            postsAdapter.refresh()
        }
        binding.retryButton.setOnClickListener { postsAdapter.retry() }
    }

    private fun showEmptyList(show: Boolean) {
        if (show) {
            binding.emptyList.visibility = View.VISIBLE
            binding.recyclerview.visibility = View.GONE
        } else {
            binding.emptyList.visibility = View.GONE
            binding.recyclerview.visibility = View.VISIBLE
        }
    }

    override val viewModel: PostsViewModel by viewModel()
}