package com.kuldeep.mvvm_hilt_demo.domain.model

/**
 * Represents a single post item in the domain layer.
 * This data class is a clean representation of a post, stripped of any
 * API-specific or database-specific details. It's used by the UI and
 * business logic layers.
 */
data class Post(
    val id: Int,
    val title: String,
    val body: String
)
