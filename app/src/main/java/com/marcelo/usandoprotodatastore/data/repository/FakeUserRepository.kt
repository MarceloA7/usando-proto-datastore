package com.marcelo.usandoprotodatastore.data.repository

import com.marcelo.usandoprotodatastore.data.enums.Profile
import com.marcelo.usandoprotodatastore.data.model.User

class FakeUserRepository() {

    fun generateUserFake(): User {
        val listUsuarios = listOf<User>(
            User("Marcelo", "Augusto", Profile.ADMINISTRADOR),
            User("Pedro", "Henrique", Profile.ADMINISTRADOR),
            User("Eduarda", "Beatriz", Profile.USUARIO)
        )
        return listUsuarios.random()
    }
}