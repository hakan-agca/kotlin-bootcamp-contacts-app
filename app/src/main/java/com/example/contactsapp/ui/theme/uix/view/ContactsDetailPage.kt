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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.contactsapp.ui.theme.data.entity.Kisiler
import com.example.contactsapp.ui.theme.uix.viewmodel.ContactsDetailPageViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactsDetailPage(personComing: Kisiler,contactsDetailPageViewModel: ContactsDetailPageViewModel){

    val personName = remember { mutableStateOf("") }
    val contactNumber = remember { mutableStateOf("") }

    LaunchedEffect(true) {
        personName.value = personComing.kisi_ad
        contactNumber.value = personComing.kisi_tel
    }

    fun update(personId : Int,personName: String, contactNumber: String){
        Log.e("kişi kayıt", "$personId-$personName - $contactNumber")
    }

    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Kişi Detay") }) }
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
                    update(personComing.kisi_id,personName.value,contactNumber.value)
                }) {
                Text(text = "Güncelle")
            }


        }
    }
}