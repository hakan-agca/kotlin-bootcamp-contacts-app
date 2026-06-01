package com.example.contactsapp.ui.theme.uix.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.contactsapp.ui.theme.data.entity.Kisiler
import com.example.contactsapp.ui.theme.data.repo.ContactsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomePageViewModel: ViewModel() {
    val contactsRepository = ContactsRepository()
    val person = MutableLiveData<List<Kisiler>>()

    init { // sayfa açıldığında çalışır
        uploadContacts()
    }

    fun  uploadContacts(){
        CoroutineScope(Dispatchers.Main).launch {
           person.value = contactsRepository.uploadContacts()
        }
    }

    fun  search(search: String){
        CoroutineScope(Dispatchers.Main).launch {
            person.value = contactsRepository.search(search)
        }
    }

    fun remove(person_id : Int){
        CoroutineScope(Dispatchers.Main).launch {
            contactsRepository.remove(person_id)
        }
        uploadContacts()
    }
}