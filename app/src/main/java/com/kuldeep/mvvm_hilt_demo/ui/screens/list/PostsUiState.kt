package com.kuldeep.mvvm_hilt_demo.ui.screens.list

import com.kuldeep.mvvm_hilt_demo.domain.model.Post

data class PostsUiState(
    val isLoading: Boolean = false,
    val posts: List<Post> = emptyList(),
    val query: String = "",
    val error: String? = null
) {
    val filtered: List<Post> =
        if (query.isBlank()) posts
        else posts.filter { post ->
            post.title.contains(
                query,
                ignoreCase = true
            )
        }
}