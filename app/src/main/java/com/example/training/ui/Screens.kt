package com.example.training.ui

sealed class Screens(val route: String) {
    object First: Screens("first")
    object Second: Screens("second")
}
