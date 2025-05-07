package com.marcelo.usandoprotodatastore.data.repository

import androidx.datastore.core.DataStore
import com.marcelo.usandoprotodatastore.data.enums.Profile
import com.marcelo.usandoprotodatastore.data.model.User
import com.marcelo.usandoprotodatastore.datastore.UserPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserPreferencesRepository @Inject constructor(private val dataStore: DataStore<UserPreferences>) {
    val userPreferences:Flow<User> = dataStore.data.map { userPref ->
        User(
            userPref.firstName,
            userPref.lastName,
            Profile.valueOf(userPref.profile)
        )
    }

    suspend fun setUserPrefer(user: User){
        dataStore.updateData {
            it.toBuilder()
                .setFirstName(user.firstName)
                .setLastName(user.lastName)
                .setProfile(user.profile.name)
                .build()
        }
    }
}