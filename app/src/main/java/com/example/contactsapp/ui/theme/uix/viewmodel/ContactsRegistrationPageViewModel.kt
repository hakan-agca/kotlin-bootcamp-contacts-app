package com.example.contactsapp.ui.theme.uix.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.contactsapp.ui.theme.data.repo.ContactsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContactsRegistrationPageViewModel @Inject constructor (var contactsRepository: ContactsRepository) : ViewModel() {

    fun save(personName: String, contactNumber: String){
        CoroutineScope(Dispatchers.Main).launch {
            contactsRepository.save(personName,contactNumber)
        }
    }

}