package com.kuldeep.mvvm_hilt_demo.data.remote

import com.kuldeep.mvvm_hilt_demo.data.remote.dto.PostDto
import com.kuldeep.mvvm_hilt_demo.domain.model.Post
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Retrofit API service interface for network operations.
 * Defines the endpoints for interacting with the remote server.
 */
interface ApiService {
    @GET("posts")
    suspend fun getPosts(): List<PostDto>

    @GET(value = "posts/{id}")
    suspend fun getPostDetails(@Path("id") postId: Int): PostDto
}