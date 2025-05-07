package com.marcelo.usandoprotodatastore.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.marcelo.usandoprotodatastore.ui.viewmodel.UserViewModel

@Composable
fun ShowUserDataStoreScreen(
    navController: NavController,
    userViewModel: UserViewModel = hiltViewModel()
) {
    val userPreferences by userViewModel
        .userPreferencesStateFlow
        .collectAsState()

    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("First Name: ${userPreferences.firstName}")
        Text("Last Name: ${userPreferences.lastName}")
        Text("Profile Name: ${userPreferences.profile}")
    }
}