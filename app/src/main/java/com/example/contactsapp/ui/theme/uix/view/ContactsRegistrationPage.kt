package com.example.contactsapp.ui.theme.uix.view

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.contactsapp.ui.theme.uix.viewmodel.ContactsRegistrationPageViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactsRegistrationPage(contactsRegistrationPageViewModel: ContactsRegistrationPageViewModel){

    val personName = remember { mutableStateOf("") }
    val contactNumber = remember { mutableStateOf("") }

    fun save(personName: String, contactNumber: String){
        Log.e("kişi kayıt", "$personName - $contactNumber")
    }

    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Kişi kayıt") }) }
    ) { paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(personName.value,
                {personName.value = it},
                label = {Text(text = "Kişi Adı")}
            )
            TextField(contactNumber.value,
                {contactNumber.value = it},
                label = {Text(text = "Kişi telefonu")}
            )
            Button(modifier = Modifier.size(250.dp,50.dp),
                onClick = {
                save(personName.value,contactNumber.value)
            }) {
                Text(text = "Kaydet")
            }


        }
    }
}