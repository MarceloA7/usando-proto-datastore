package com.marcelo.usandoprotodatastore.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marcelo.usandoprotodatastore.data.model.User
import com.marcelo.usandoprotodatastore.data.repository.FakeUserRepository
import com.marcelo.usandoprotodatastore.data.repository.UserPreferencesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val fakeUserRepository: FakeUserRepository,
    private val userPreferencesRepository: UserPreferencesRepository
):ViewModel() {

    val userPreferencesStateFlow = userPreferencesRepository.userPreferences.stateIn(
        viewModelScope, SharingStarted.WhileSubscribed(5000), User()
    )

     fun setUserPrefer(){
         viewModelScope.launch {
             userPreferencesRepository
                 .setUserPrefer(getUserFake())
         }
    }

    private fun getUserFake():User{
        return fakeUserRepository.generateUserFake()
    }
}