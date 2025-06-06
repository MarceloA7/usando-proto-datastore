package com.marcelo.usandoprotodatastore.di

import android.content.Context
import androidx.datastore.core.DataStore
import com.marcelo.usandoprotodatastore.data.datastore.userPreferencesStore
import com.marcelo.usandoprotodatastore.data.repository.FakeUserRepository
import com.marcelo.usandoprotodatastore.datastore.UserPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HiltModule {

    @Provides
    @Singleton
    fun providerDataStore(@ApplicationContext context: Context): DataStore<UserPreferences> {
        return context.userPreferencesStore
    }

    @Provides
    @Singleton
    fun providerFakeUser():FakeUserRepository{
        return FakeUserRepository()
    }
}