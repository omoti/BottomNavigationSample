package com.omoti.bottomnavigationsample.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.omoti.bottomnavigationsample.ui.theme.BottomNavigationSampleTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentScreen(text: String) {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = text) },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary,
                titleContentColor = MaterialTheme.colorScheme.onPrimary,
            ),
        )
    }) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
        ) {
            items(30) { index ->
                ListItem(headlineContent = { Text(text = "item $index") })
            }
        }
    }
}

@Preview
@Composable
fun ContentScreenPreview() {
    BottomNavigationSampleTheme {
        ContentScreen("content")
    }
}
