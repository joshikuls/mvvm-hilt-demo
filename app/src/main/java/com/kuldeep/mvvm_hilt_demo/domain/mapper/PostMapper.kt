package com.kuldeep.mvvm_hilt_demo.domain.mapper

import com.kuldeep.mvvm_hilt_demo.data.remote.dto.PostDto
import com.kuldeep.mvvm_hilt_demo.domain.model.Post

/**
 * Maps a [PostEntity] data layer model to a [Post] domain layer model.
 * @return The corresponding [Post] domain model.
 */
fun PostDto.toDomain(): Post = Post(
    id = id,
    title = title,
    body = body
)