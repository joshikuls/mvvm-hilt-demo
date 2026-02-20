package com.kuldeep.mvvm_hilt_demo.ui.screens.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kuldeep.mvvm_hilt_demo.data.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val repository: PostRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        PostsUiState(
            isLoading = true
        )
    )
    val uiState = _uiState.asStateFlow()

    init {
        load()
    }

    fun onQueryChange(text: String) {
        _uiState.update { state ->
            state.copy(query = text)
        }
    }

    private fun load() {
        viewModelScope.launch {
            _uiState.update { state ->
                state.copy(
                    isLoading = true,
                    error = null
                )
            }
            try {
                val posts = repository.getPosts()
                _uiState.update { state ->
                    state.copy(
                        isLoading = false,
                        posts = posts
                    )
                }
            } catch (e: Exception) {
                _uiState.update { state ->
                    state.copy(
                        isLoading = false,
                        error = "Failed to load posts. Please try again"
                    )
                }
            }
        }
    }

    fun retry() = load()
}