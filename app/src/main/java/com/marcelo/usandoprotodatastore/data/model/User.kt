package com.marcelo.usandoprotodatastore.data.model

import com.marcelo.usandoprotodatastore.data.enums.Profile

data class User(
    val firstName:String,
    val lastName:String,
    val profile: Profile
)
