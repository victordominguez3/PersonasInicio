package com.example.personasinicio.errors

sealed class PersonaError(val message:String) {
    class NotValid(message: String) : PersonaError(message)
}