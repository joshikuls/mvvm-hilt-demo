package com.kuldeep.mvvm_hilt_demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kuldeep.mvvm_hilt_demo.navigation.AppNavGraph
import com.kuldeep.mvvm_hilt_demo.ui.screens.list.PostScreen
import com.kuldeep.mvvm_hilt_demo.ui.theme.MVVMHiltDemoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MVVMHiltDemoTheme(darkTheme = false) {
                AppNavGraph()
            }
        }
    }
}