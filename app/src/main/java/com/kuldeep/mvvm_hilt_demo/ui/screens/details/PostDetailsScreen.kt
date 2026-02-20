package com.kuldeep.mvvm_hilt_demo.ui.screens.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kuldeep.mvvm_hilt_demo.domain.model.Post
import com.kuldeep.mvvm_hilt_demo.ui.components.ErrorState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostDetailsScreen(
    onBack: () -> Unit,
    viewModel: PostDetailsViewModel = hiltViewModel()
) {

    val state by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Post Details")
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Text("Back")
                    }
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
                .padding(paddingValues = paddingValues)
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
                        modifier = Modifier.align(Alignment.Center)
                    )
                }

                else -> {
                    state.post?.let {
                        ScreenDetails(postDetails = it)
                    } ?: run {
                        ErrorState(
                            message = "Post not found!",
                            onRetry = viewModel::retry,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }

            }

        }
    }
}

@Composable
fun ScreenDetails(
    modifier: Modifier = Modifier,
    postDetails: Post
) {

    Card(
        modifier = modifier.padding(8.dp),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 8.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {

        Column(
            modifier = modifier.padding(8.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "ID# ${postDetails.id}",
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                modifier = modifier.padding(top = 16.dp),
                text = postDetails.title,
                style = MaterialTheme.typography.bodyLarge
            )
            HorizontalDivider(
                modifier = modifier.padding(top = 16.dp),
                thickness = 1.dp,
                color = MaterialTheme.colorScheme.outlineVariant
            )
            Text(
                modifier = modifier.padding(top = 16.dp),
                text = postDetails.body,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}