package com.example.composeworkshop.ui.main.tabs.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeworkshop.LoadState
import com.example.composeworkshop.core.request.Request
import com.example.composeworkshop.core.request.requestFlow
import com.example.composeworkshop.domain.ProductsCategoryEntity
import com.example.composeworkshop.interactor.feed.FeedInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val feedInteractor: FeedInteractor
) : ViewModel() {

    private val _loadState = MutableStateFlow(LoadState.Loading)
    val loadState: StateFlow<LoadState> get() = _loadState.asStateFlow()

    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean> get() = _isRefreshing.asStateFlow()

    private val _categories = MutableStateFlow(emptyList<ProductsCategoryEntity>())
    val categories: StateFlow<List<ProductsCategoryEntity>> get() = _categories.asStateFlow()

    init {
        loadFeed()
    }

    fun refresh() {
        loadFeedInternal(true)
    }

    fun loadFeed() {
        loadFeedInternal(false)
    }

    private fun loadFeedInternal(refresh: Boolean) {
        viewModelScope.launch {
            requestFlow {
                feedInteractor.getCategories()
            }.collect { requestState ->
                when (requestState) {
                    is Request.Loading<*> -> {
                        _isRefreshing.value = refresh
                        if (!refresh) {
                            _loadState.value = LoadState.Loading
                        }
                    }
                    is Request.Success<*> -> {
                        _isRefreshing.value = false
                        _categories.value = requestState.data as List<ProductsCategoryEntity>
                        _loadState.value = LoadState.Succeed
                    }
                    is Request.Error<*> -> {
                        _isRefreshing.value = false
                        if (!refresh) {
                            _loadState.value = LoadState.Error
                        }
                    }
                }
            }
        }
    }
}