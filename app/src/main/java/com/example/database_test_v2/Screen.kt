package com.example.database_test_v2

sealed class Screen(val route: String) {
    object HomeScreen:Screen("home_screen")
    object RegistrationScreen:Screen("registration_screen")
}
