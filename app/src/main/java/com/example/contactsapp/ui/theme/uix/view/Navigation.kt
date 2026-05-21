package com.example.contactsapp.ui.theme.uix.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.contactsapp.ui.theme.data.entity.Kisiler
import com.google.gson.Gson

@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "homePage") {
        composable("homePage"){
            HomePage(navController)
        }


        composable(
            "contactsDetailPage/{person}",
            arguments = listOf(
                navArgument("person"){type = NavType.StringType})
        ){
            val json = it.arguments?.getString("person")
            val person = Gson().fromJson(json, Kisiler::class.java)
            ContactsDetailPage(person)
        }

        composable("contactsRegistrationPage"){
            ContactsRegistrationPage(navController)
        }
    }

}