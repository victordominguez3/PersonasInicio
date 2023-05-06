package com.example.personasinicio.models

data class Persona(
    val nombre: String,
    val edad: Int,
    val correo: String
) {
    override fun toString(): String {
        return "Persona -> Nombre: $nombre, Edad: $edad, Correo: $correo"
    }
}

data class PersonaDto(
    val nombre: String,
    val edad: String,
    val correo: String
) {
    override fun toString(): String {
        return "Persona -> Nombre: $nombre, Edad: $edad, Correo: $correo"
    }
}