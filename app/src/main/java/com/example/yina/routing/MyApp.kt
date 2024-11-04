package com.example.yina.routing

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.yina.view.home.NewsListScreen
import com.example.yina.view.onboarding.OnboardingScreen
import com.example.yina.viewmodel.NewsViewModel

@Composable

fun MyApp(
    newsViewModel: NewsViewModel
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "onboarding") {
        composable(Screen.Onboarding.route) {
            OnboardingScreen(navController = navController)
        }
        composable(Screen.Home.route) {
            NewsListScreen(
                newsViewModel = newsViewModel,
                navController = navController
            )
        }
    }
}


sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object Onboarding : Screen("onboarding")
    data object Details : Screen("details/{itemId}") {
        fun createRoute(itemId: String) = "details/$itemId"
    }
}
