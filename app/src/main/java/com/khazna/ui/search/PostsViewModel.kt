package com.khazna.ui.search

import androidx.lifecycle.*
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.khazna.base.BaseViewModel
import com.khazna.common.DEFAULT_PAGE_SIZE
import com.khazna.data.local.entity.PostModel
import com.khazna.domain.usecase.post.PostsUseCase
import kotlinx.coroutines.flow.Flow

class PostsViewModel(private val useCase: PostsUseCase) : BaseViewModel() {

    val fetchPosts = MutableLiveData<Boolean>()

    fun getPosts(pagingConfig: PagingConfig = getDefaultPageConfig()): LiveData<PagingData<PostModel>> {
        return Transformations.switchMap(fetchPosts) {
            useCase.letPostsFlowDb(pagingConfig = pagingConfig).asLiveData()
                .cachedIn(viewModelScope)
        }
    }

    private fun getDefaultPageConfig(): PagingConfig {
        return PagingConfig(pageSize = DEFAULT_PAGE_SIZE, enablePlaceholders = false)
    }
}
