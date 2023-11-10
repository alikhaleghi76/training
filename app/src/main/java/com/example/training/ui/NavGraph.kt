package com.example.training.ui

import UsersScreen
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.training.feature.intro.presentation.IntroScreen
import com.example.training.feature.users.presentaion.viewmodel.UserViewModel


@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.First.route
    )
    {
        composable(route = Screens.First.route) {
            IntroScreen(navController)
        }
        composable(route = Screens.Second.route) {
            UsersScreen(navController = navController, viewModel = hiltViewModel<UserViewModel>())
        }
    }
}