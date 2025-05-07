package com.marcelo.usandoprotodatastore.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.marcelo.usandoprotodatastore.ui.viewmodel.UserViewModel

@Composable
fun SetUserDataStoreScreen(
    navController:NavController,
    userViewModel: UserViewModel = hiltViewModel()
) {

    var setUsersPref by remember {
        mutableStateOf(false)
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                userViewModel
                    .setUserPrefer()
                setUsersPref = true
            }) {
                Icon(Icons.Default.Done, "Icon para o botão de executar a adição do usuario")
            }
        }
    ) { paddingScaffold ->
        Column(
            modifier = Modifier
                .padding(paddingScaffold)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if(setUsersPref){
                Text("Usuarios foram setados.")
                Button(onClick = {
                    navController.navigate("show_user_screen")
                }) {
                    Text("Show usuarios preference")
                }
            } else {
                Text("Sem usuarios coletados e setados.")
            }
        }
    }
}