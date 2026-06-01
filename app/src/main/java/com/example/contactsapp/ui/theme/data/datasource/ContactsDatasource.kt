package com.example.contactsapp.ui.theme.data.datasource

import android.util.Log
import com.example.contactsapp.ui.theme.data.entity.Kisiler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ContactsDatasource {
   suspend fun save(personName: String, contactNumber: String){
        Log.e("kişi kayıt", "$personName - $contactNumber")
    }

    suspend fun update(personId : Int,personName: String, contactNumber: String){
        Log.e("kişi kayıt", "$personId-$personName - $contactNumber")
    }

    suspend fun remove(person_id : Int){
        Log.e("Kişi sil", person_id.toString())
    }

    suspend fun uploadContacts() : List<Kisiler> = withContext(Dispatchers.IO){
        val persons = ArrayList<Kisiler>()
        val k1 = Kisiler(1, "Ahmet", "111")
        val k2 = Kisiler(2, "mehmet", "222")
        val k3 = Kisiler(2, "hakan", "222")
        persons.add(k1)
        persons.add(k2)
        persons.add(k3)

        return@withContext persons
    }
    suspend fun search(search : String) : List<Kisiler> = withContext(Dispatchers.IO){
        val persons = ArrayList<Kisiler>()
        val k1 = Kisiler(1, "Ahmet", "111")

        persons.add(k1)

        return@withContext persons
    }
}