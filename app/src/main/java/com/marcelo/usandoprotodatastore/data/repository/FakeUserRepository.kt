package com.marcelo.usandoprotodatastore.data.repository

import androidx.datastore.core.DataStore
import com.marcelo.usandoprotodatastore.data.enums.Profile
import com.marcelo.usandoprotodatastore.data.model.User
import com.marcelo.usandoprotodatastore.datastore.UserPreferences
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FakeUserRepository @Inject constructor(private val dataStore: DataStore<UserPreferences>) {
    val userPreferences:Flow<UserPreferences> = dataStore.data

    suspend fun setUserPrefer(user: User){
        dataStore.updateData {
            it.toBuilder().setFirstName(user.firstName).build()
            it.toBuilder().setLastName(user.lastName).build()
            it.toBuilder().setProfile(user.profile.name).build()
        }
    }

    fun getUser(): User {
        return User(
            "Marcelo",
            "Augusto",
            Profile.ADMINISTRADOR
        )
    }
}