package com.kuldeep.mvvm_hilt_demo.ui.screens.details

import com.kuldeep.mvvm_hilt_demo.domain.model.Post

data class PostDetailsUiState(
    val isLoading: Boolean = false,
    val post: Post? = null,
    val error: String? = null
)
