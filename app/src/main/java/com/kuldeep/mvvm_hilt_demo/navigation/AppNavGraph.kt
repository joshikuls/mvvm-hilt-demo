package com.kuldeep.mvvm_hilt_demo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kuldeep.mvvm_hilt_demo.ui.screens.details.PostDetailsScreen
import com.kuldeep.mvvm_hilt_demo.ui.screens.list.PostScreen

@Composable
fun AppNavGraph() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.POSTS
    ) {
        composable(Routes.POSTS) {
            PostScreen(
                onPostClick = { postId ->
                    navController.navigate(
                        "${Routes.POST_DETAIL}/$postId"
                    )
                }
            )
        }

        composable(
            route = "${Routes.POST_DETAIL}/{postId}",
            arguments = listOf(
                navArgument("postId") {
                    type = NavType.IntType
                }
            )
        ) {
            PostDetailsScreen(
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}