package com.example.nexus

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.nexus.ui.navigation.AppNavHost

@Composable
fun NexusApp(navController: NavHostController = rememberNavController()) {
    AppNavHost(navController = navController)
}
