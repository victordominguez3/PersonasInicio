package com.example.personasinicio.validators

import com.example.personasinicio.errors.PersonaError
import com.example.personasinicio.models.Persona
import com.example.personasinicio.models.PersonaDto
import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import mu.KotlinLogging

private val logger = KotlinLogging.logger{}
private val nombreRegex = Regex("^([a-zA-Z]+ *)+")
private val edadRegex = Regex("^\\d+$")
private val correoRegex = Regex("^[\\w.]+@\\w+(.es|.com|.org)$")

fun PersonaDto.validar(): Result<PersonaDto, PersonaError> {
    logger.debug { "Validando persona -> $this" }
    require(this.nombre.matches(nombreRegex)) { return Err(PersonaError.NotValid("Se debe introducir un nombre válido")) }
    require(this.edad.matches(edadRegex)) { return Err(PersonaError.NotValid("Se debe introducir una edad válida")) }
    require(this.correo.matches(correoRegex)) { return Err(PersonaError.NotValid("Se debe introducir un correo válido")) }
    return Ok(this)
}