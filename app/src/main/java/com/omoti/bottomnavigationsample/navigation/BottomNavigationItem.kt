package com.omoti.bottomnavigationsample.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

enum class BottomNavigationItem(val label: String, val icon: ImageVector, val route: String) {
    Home(label = "Home", icon = Icons.Default.Home, route = "home"),
    Favorite(label = "Favorite", icon = Icons.Default.Favorite, route = "favorite"),
    Search(label = "Search", icon = Icons.Default.Search, route = "search"),
    Settings(label = "Settings", icon = Icons.Default.Settings, route = "settings"),
}
