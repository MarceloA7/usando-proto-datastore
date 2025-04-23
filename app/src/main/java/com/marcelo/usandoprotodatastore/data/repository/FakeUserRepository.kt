package com.marcelo.usandoprotodatastore.data.repository

import com.marcelo.usandoprotodatastore.data.enums.Profile
import com.marcelo.usandoprotodatastore.data.model.User

class FakeUserRepository {
    fun getUser(): User {
        return User(
            "Marcelo",
            "Augusto",
            Profile.ADMINISTRADOR
        )
    }
}