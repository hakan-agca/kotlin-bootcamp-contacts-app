package com.example.contactsapp.ui.theme.uix.viewmodel

import androidx.lifecycle.ViewModel
import com.example.contactsapp.ui.theme.data.repo.ContactsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ContactsDetailPageViewModel : ViewModel()  {
    val contactsRepository = ContactsRepository()

   fun update(personId : Int,personName: String, contactNumber: String){
        CoroutineScope(Dispatchers.Main).launch {
            contactsRepository.update(personId,personName,contactNumber)
        }
    }
}