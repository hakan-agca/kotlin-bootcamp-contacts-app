package com.example.contactsapp.ui.theme.data.repo

import android.icu.text.StringSearch
import android.util.Log
import com.example.contactsapp.ui.theme.data.datasource.ContactsDatasource
import com.example.contactsapp.ui.theme.data.entity.Kisiler

class ContactsRepository(var contactsDatasource: ContactsDatasource) {


    suspend fun save(personName: String, contactNumber: String) =
        contactsDatasource.save(personName, contactNumber)

    suspend fun update(personId: Int, personName: String, contactNumber: String) =
        contactsDatasource.update(personId, personName, contactNumber)

    suspend fun remove(person_id : Int) = contactsDatasource.remove(person_id)

    suspend fun uploadContacts() : List<Kisiler> = contactsDatasource.uploadContacts()

    suspend fun search(search: String) : List<Kisiler> = contactsDatasource.search(search)

}