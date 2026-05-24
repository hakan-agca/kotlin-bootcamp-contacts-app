package com.example.contactsapp.ui.theme.uix.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.contactsapp.R
import com.example.contactsapp.ui.theme.data.entity.Kisiler
import com.google.gson.Gson
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(navController: NavController) {
    val search = remember { mutableStateOf(false) }
    val searchTf = remember { mutableStateOf("") }
    val persons = remember { mutableStateListOf<Kisiler>() }
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(key1 = true) {
        val k1 = Kisiler(1, "Ahmet", "111")
        val k2 = Kisiler(2, "mehmet", "222")
        val k3 = Kisiler(2, "hakan", "222")
        persons.add(k1)
        persons.add(k2)
        persons.add(k3)
    }


    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    if (search.value) {
                        TextField(
                            searchTf.value,
                            { searchTf.value = it },
                            label = { Text(text = "Ara") },
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
                    } else {
                        Text(text = "Kişiler")
                    }
                },
                actions = {
                    if (search.value) {
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
                    } else {
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
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            items(
                count = persons.count(),
                itemContent = {
                    val person = persons[it]
                    Card(
                        modifier = Modifier.padding(all = 5.dp)

                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth()
                                .clickable {
                                    val personJson = Gson().toJson(person)
                                    navController.navigate("contactsDetailPage/$personJson")
                                },
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(
                                modifier = Modifier.padding(all = 10.dp)
                            ) {
                                Text(text = person.kisi_ad, fontSize = 20.sp)
                                Spacer(modifier = Modifier.size(10.dp))
                                Text(text = person.kisi_tel)
                            }
                            IconButton(onClick = {
                                scope.launch {
                                    val sb = snackbarHostState.
                                    showSnackbar("${person.kisi_ad} Silinsin mi?",
                                        actionLabel = "Evet")
                                    if (sb == SnackbarResult.ActionPerformed){
                                        persons.remove(person)
                                    }
                                }
                            }) {
                                Icon(
                                    painter = painterResource(R.drawable.close),
                                    contentDescription = "",
                                    tint = Color.Gray
                                )
                            }
                        }

                    }
                }
            )



        }
    }
}
/* Button(
                onClick = {
                    val person = Kisiler(1, "Ahmet", "11111")
                    val personJson = Gson().toJson(person)
                    navController.navigate("contactsDetailPage/$personJson")
                }) {
                Text(text = "Kaydet")
            }*/