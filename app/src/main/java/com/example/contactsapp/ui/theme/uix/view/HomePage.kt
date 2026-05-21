package com.example.contactsapp.ui.theme.uix.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.contactsapp.R
import com.example.contactsapp.ui.theme.data.entity.Kisiler
import com.google.gson.Gson

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(navController: NavController) {
    val search = remember { mutableStateOf(false) }
    val searchTf = remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    if(search.value){
                        TextField(searchTf.value,
                            {searchTf.value = it},
                            label = {Text(text = "Ara")},
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color.Transparent,
                                focusedLabelColor = Color.Transparent,
                                unfocusedContainerColor = Color.Transparent,
                                disabledContainerColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                disabledIndicatorColor = Color.Transparent
                            )

                        )
                    }else{
                        Text(text = "Kişiler")
                    }
                },
                actions = {
                    if(search.value){
                        IconButton(onClick = {
                            search.value = false
                            searchTf.value = ""
                        }) {
                            Icon(
                                painter = painterResource(R.drawable.close),
                                contentDescription = "",
                                tint = Color.Black
                            )
                        }
                    }else{
                        IconButton(onClick = {
                            search.value = true
                        }) {
                            Icon(
                                painter = painterResource(R.drawable.search),
                                contentDescription = "",
                                tint = Color.Black
                            )
                        }
                    }

                }
            )
        },
        floatingActionButton = {

            FloatingActionButton(
                onClick = { navController.navigate("contactsRegistrationPage") },
                content = {
                    Icon(painter = painterResource(R.drawable.add), contentDescription = "")
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    val person = Kisiler(1, "Ahmet", "11111")
                    val personJson = Gson().toJson(person)
                    navController.navigate("contactsDetailPage/$personJson")
                }) {
                Text(text = "Kaydet")
            }


        }
    }
}