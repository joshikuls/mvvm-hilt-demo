package com.kuldeep.mvvm_hilt_demo.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
    value: String
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        singleLine = true,
        label = {
            Text("Search by title")
        }
    )
}