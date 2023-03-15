package com.omoti.bottomnavigationsample.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.omoti.bottomnavigationsample.screens.ContentScreen

@Composable
fun BasicNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomNavigationItem.Home.route) {
        composable(route = BottomNavigationItem.Home.route) {
            ContentScreen(BottomNavigationItem.Home.label)
        }
        composable(route = BottomNavigationItem.Favorite.route) {
            ContentScreen(BottomNavigationItem.Favorite.label)
        }
        composable(route = BottomNavigationItem.Search.route) {
            ContentScreen(BottomNavigationItem.Search.label)
        }
        composable(route = BottomNavigationItem.Settings.route) {
            ContentScreen(BottomNavigationItem.Settings.route)
        }
    }
}
