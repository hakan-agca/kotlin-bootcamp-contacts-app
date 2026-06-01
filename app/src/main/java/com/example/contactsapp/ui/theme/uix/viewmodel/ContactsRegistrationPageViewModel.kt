package com.example.contactsapp.ui.theme.uix.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.contactsapp.ui.theme.data.repo.ContactsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ContactsRegistrationPageViewModel : ViewModel() {
    val contactsRepository = ContactsRepository()

    fun save(personName: String, contactNumber: String){
        CoroutineScope(Dispatchers.Main).launch {
            contactsRepository.save(personName,contactNumber)
        }
    }

}