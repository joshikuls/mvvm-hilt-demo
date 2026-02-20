package com.kuldeep.mvvm_hilt_demo.data.repository

import com.kuldeep.mvvm_hilt_demo.data.remote.ApiService
import com.kuldeep.mvvm_hilt_demo.domain.mapper.toDomain
import com.kuldeep.mvvm_hilt_demo.domain.model.Post
import javax.inject.Inject

/**
 * Implementation of [PostRepository].
 * This class is responsible for fetching post data from a remote source (like a network API)
 * and providing it to the application's domain or UI layer.
 *
 * @property apiService The remote API service used to fetch post data.
 * @constructor Creates an instance of the PostRepositoryImpl.
 */
class PostRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : PostRepository {
    override suspend fun getPosts(): List<Post> {
        return apiService.getPosts().map { it.toDomain() }
    }
}