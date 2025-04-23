package com.marcelo.usandoprotodatastore.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.marcelo.usandoprotodatastore.data.repository.FakeUserRepository
import javax.inject.Inject

class UserViewModel @Inject constructor(
    val fakeUserRepository: FakeUserRepository
):ViewModel() {


}