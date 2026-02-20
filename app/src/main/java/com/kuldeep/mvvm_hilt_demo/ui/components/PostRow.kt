package com.kuldeep.mvvm_hilt_demo.ui.components

import android.R.attr.text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.kuldeep.mvvm_hilt_demo.domain.model.Post

@Composable
fun PostRow(
    modifier: Modifier = Modifier,
    post: Post
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = post.title,
            style = MaterialTheme.typography.titleMedium,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = post.body,
            style = MaterialTheme.typography.bodySmall,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}