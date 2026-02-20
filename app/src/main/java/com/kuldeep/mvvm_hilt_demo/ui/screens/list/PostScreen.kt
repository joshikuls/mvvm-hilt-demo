package com.kuldeep.mvvm_hilt_demo.ui.screens.list

import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kuldeep.mvvm_hilt_demo.ui.components.ErrorState
import com.kuldeep.mvvm_hilt_demo.ui.components.PostRow
import com.kuldeep.mvvm_hilt_demo.ui.components.SearchBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostScreen(
    onPostClick: (Int) -> Unit,
    viewModel: PostsViewModel = hiltViewModel()
) {

    val state by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Posts",
                        style = MaterialTheme.typography.titleLarge
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            when {
                state.isLoading -> {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }

                state.error != null -> {
                    ErrorState(
                        message = state.error ?: "Something went wrong!",
                        onRetry = viewModel::retry,
                        modifier = Modifier.align(
                            Alignment.Center
                        )
                    )
                }

                else -> {
                    LazyColumn {
                        item {
                            SearchBar(
                                value = state.query,
                                onValueChange = viewModel::onQueryChange
                            )
                        }

                        items(state.filtered, key = { it.id }) { post ->
                            PostRow(
                                post = post,
                                onPostClick = { onPostClick(post.id) }
                            )
                        }
                    }

                }
            }
        }
    }
}