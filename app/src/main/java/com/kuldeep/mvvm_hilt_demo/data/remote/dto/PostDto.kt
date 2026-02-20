package com.kuldeep.mvvm_hilt_demo.data.remote.dto

/**
 * Represents a single post data transfer object (DTO) received from the remote API.
 * This class is used for parsing the JSON response from the network.
 */
data class PostDto(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)
