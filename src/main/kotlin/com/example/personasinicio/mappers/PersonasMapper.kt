package com.example.personasinicio.mappers

import com.example.personasinicio.models.Persona
import com.example.personasinicio.models.PersonaDto

fun PersonaDto.toPersona() = Persona(
    this.nombre,
    this.edad.toInt(),
    this.correo
)