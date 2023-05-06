package com.example.personasinicio.repositories

import com.example.personasinicio.models.Persona
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

class PersonasRepository {
    private val personas = mutableListOf<Persona>()

    fun buscarTodos(): List<Persona> {
        logger.debug { "PersonasRepository -> Buscar todos" }
        return personas
    }

    fun guardar(persona: Persona) {
        logger.debug { "PersonasRepository -> Guardando persona: $persona" }
        personas.add(persona)
        println(persona)
    }
}