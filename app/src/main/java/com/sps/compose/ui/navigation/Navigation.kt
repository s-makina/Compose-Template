package com.sps.compose.ui.navigation

import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sps.compose.ui.TestPage
import com.sps.compose.ui.pages.HomeScreen
import com.sps.compose.ui.viewmodel.UserViewModel

@Composable
fun Navigation() {
    val userViewModel: UserViewModel = hiltViewModel()
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.HomePage.route) {
        composable(route = Screen.SplashScreen.route) {
            TestPage ()
//            SplashScreen(navController, userViewModel)
        }

        composable(route = Screen.LoginPage.route) {
//            LoginPage(navController, userViewModel)
        }

        composable(route = Screen.Register.route) {
//            Signup(navController, userViewModel)
        }

        composable(route = Screen.HomePage.route) {
            HomeScreen()
        }
    }
}
