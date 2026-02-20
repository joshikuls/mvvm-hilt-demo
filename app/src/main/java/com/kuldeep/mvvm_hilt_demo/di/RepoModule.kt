package com.kuldeep.mvvm_hilt_demo.di

import com.kuldeep.mvvm_hilt_demo.data.repository.PostRepository
import com.kuldeep.mvvm_hilt_demo.data.repository.PostRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {

    @Binds
    @Singleton
    abstract fun bindPostsRepository(
        impl: PostRepositoryImpl
    ): PostRepository
}