package com.omoti.bottomnavigationsample.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.omoti.bottomnavigationsample.navigation.BasicNavHost
import com.omoti.bottomnavigationsample.navigation.BottomNavigationItem
import com.omoti.bottomnavigationsample.ui.theme.BottomNavigationSampleTheme

/**
 * Material3 NavigationBar
 * https://developer.android.com/reference/kotlin/androidx/compose/material3/package-summary#NavigationBar
 */
@Composable
fun Material3Screen() {
    val navController = rememberNavController()
    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(bottomBar = {
        NavigationBar {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination
            BottomNavigationItem.values().forEachIndexed { index, item ->
                NavigationBarItem(
                    icon = { Icon(imageVector = item.icon, contentDescription = item.label) },
                    label = { Text(item.label) },
                    selected = currentDestination?.hierarchy?.any { it.route == item.route } == true,
                    onClick = {
                        navController.navigate(item.route) {
                            // 戻り先を先頭タブにしてタブ切り替えの履歴が積まれないようにする
                            // どのタブからでも戻るボタンでHomeに戻る
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            // popUpToのときに保存した状態を復元
                            restoreState = true

                            // 同じ画面が複数重ならないようにする
                            launchSingleTop = true
                        }
                        selectedIndex = index
                    },
                )
            }
        }
    }) { paddingValues ->
        Column(Modifier.padding(paddingValues)) {
            BasicNavHost(navController = navController)
        }
    }
}

@Preview
@Composable
fun BasicScreenPreview() {
    BottomNavigationSampleTheme {
        Material3Screen()
    }
}
