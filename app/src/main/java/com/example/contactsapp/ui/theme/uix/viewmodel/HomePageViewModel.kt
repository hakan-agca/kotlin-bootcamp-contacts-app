package com.example.contactsapp.ui.theme.uix.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.contactsapp.ui.theme.data.entity.Kisiler
import com.example.contactsapp.ui.theme.data.repo.ContactsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomePageViewModel @Inject constructor(var contactsRepository: ContactsRepository): ViewModel() {
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