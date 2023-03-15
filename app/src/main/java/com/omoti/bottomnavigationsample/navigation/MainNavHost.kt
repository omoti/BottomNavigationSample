package com.omoti.bottomnavigationsample.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.omoti.bottomnavigationsample.screens.MainScreen
import com.omoti.bottomnavigationsample.screens.Material3Screen

@Composable
fun MainNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "main") {
        composable(route = "main") {
            MainScreen(onNavigateMaterial3 = { navController.navigate(route = "material3") })
        }
        composable(route = "material3") {
            Material3Screen()
        }
    }
}
