package com.kuldeep.mvvm_hilt_demo.ui.screens.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kuldeep.mvvm_hilt_demo.data.repository.PostRepository
import com.kuldeep.mvvm_hilt_demo.ui.screens.list.PostsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostDetailsViewModel @Inject constructor(
    private val repository: PostRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val postId: Int = checkNotNull(savedStateHandle["postId"])

    private val _uiState = MutableStateFlow(
        value = PostDetailsUiState(
            isLoading = true
        )
    )
    val uiState = _uiState.asStateFlow()

    init {
        load()
    }

    private fun load() {
        viewModelScope.launch {
            _uiState.update { state ->
                state.copy(isLoading = true, error = null)
            }

            try {
                val postDetails = repository.getPostDetails(postId)
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        post = postDetails,
                        error = null
                    )
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = it.error ?: "Something went wrong!"
                    )
                }
            }
        }
    }

    fun retry() = load()
}