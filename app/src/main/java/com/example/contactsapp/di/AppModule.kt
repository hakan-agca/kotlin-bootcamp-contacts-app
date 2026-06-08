package com.example.contactsapp.di

import com.example.contactsapp.ui.theme.data.datasource.ContactsDatasource
import com.example.contactsapp.ui.theme.data.repo.ContactsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideContactsRepository(contactsDatasource: ContactsDatasource) : ContactsRepository {
        return ContactsRepository(contactsDatasource)
    }

    @Provides
    @Singleton
    fun provideContactsDatasource() : ContactsDatasource{
        return ContactsDatasource()
    }
}