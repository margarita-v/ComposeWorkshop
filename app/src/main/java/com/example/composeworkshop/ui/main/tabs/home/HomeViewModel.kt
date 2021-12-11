package com.example.composeworkshop.ui.main.tabs.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeworkshop.LoadState
import com.example.composeworkshop.core.request.Request
import com.example.composeworkshop.core.request.requestFlow
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

    init {
        loadFeed()
    }

    private fun loadFeed() {
        viewModelScope.launch {
            requestFlow {
                feedInteractor.getCategories()
            }.collect { requestState ->
                _loadState.value = when (requestState) {
                    is Request.Loading<*> -> LoadState.Loading
                    is Request.Success<*> -> LoadState.Succeed
                    is Request.Error<*> -> LoadState.Error
                }
            }
        }
    }
}