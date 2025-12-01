package com.example.nexus

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.nexus.ui.navigation.NavigationHost

@Composable
fun NexusApp(navController: NavHostController = rememberNavController()) {
    NavigationHost(navController)
}
