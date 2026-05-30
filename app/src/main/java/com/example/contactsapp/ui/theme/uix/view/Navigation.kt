package com.example.contactsapp.ui.theme.uix.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.contactsapp.ui.theme.data.entity.Kisiler
import com.example.contactsapp.ui.theme.uix.viewmodel.ContactsDetailPageViewModel
import com.example.contactsapp.ui.theme.uix.viewmodel.ContactsRegistrationPageViewModel
import com.example.contactsapp.ui.theme.uix.viewmodel.HomePageViewModel
import com.google.gson.Gson

@Composable
fun Navigation(
    homeViewModel: HomePageViewModel,
    contactsDetailPageViewModel: ContactsDetailPageViewModel,
    contactsRegistrationPageViewModel: ContactsRegistrationPageViewModel
) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "homePage") {
        composable("homePage") {
            HomePage(navController, homeViewModel)
        }

        composable("contactsRegistrationPage") {
            ContactsRegistrationPage(contactsRegistrationPageViewModel)
        }
        composable(
            "contactsDetailPage/{person}",
            arguments = listOf(
                navArgument("person") { type = NavType.StringType })
        ) {
            val json = it.arguments?.getString("person")
            val person = Gson().fromJson(json, Kisiler::class.java)
            ContactsDetailPage(person,contactsDetailPageViewModel)
        }


    }

}