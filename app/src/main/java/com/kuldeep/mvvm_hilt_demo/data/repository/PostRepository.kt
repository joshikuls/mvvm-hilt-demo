package com.kuldeep.mvvm_hilt_demo.data.repository

import com.kuldeep.mvvm_hilt_demo.domain.model.Post
import retrofit2.http.POST

interface PostRepository {
    suspend fun getPosts(): List<Post>
}