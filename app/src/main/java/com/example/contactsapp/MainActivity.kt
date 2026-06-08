package com.example.contactsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.contactsapp.ui.theme.ContactsAppTheme
import com.example.contactsapp.ui.theme.uix.view.Navigation
import com.example.contactsapp.ui.theme.uix.viewmodel.ContactsDetailPageViewModel
import com.example.contactsapp.ui.theme.uix.viewmodel.ContactsRegistrationPageViewModel
import com.example.contactsapp.ui.theme.uix.viewmodel.HomePageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
     val homePageViewModel : HomePageViewModel by viewModels()
    val contactsDetailPageViewModel : ContactsDetailPageViewModel by viewModels()
    val contactsRegistrationPageViewModel : ContactsRegistrationPageViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContactsAppTheme {
                Navigation(homePageViewModel,contactsDetailPageViewModel,contactsRegistrationPageViewModel)
            }
        }
    }
}

