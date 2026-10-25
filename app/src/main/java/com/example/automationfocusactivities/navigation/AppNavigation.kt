package com.example.automationfocusactivities.navigation

import com.example.automationfocusactivities.screens.LoginScreen
import com.example.automationfocusactivities.screens.SignUpScreen
import com.example.automationfocusactivities.screens.HomeScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {

        composable("login") {

            LoginScreen(

                onLoginSuccess = {
                    navController.navigate("home")
                },

                onSignUpClick = {
                    navController.navigate("signup")
                }
            )
        }

    }
}