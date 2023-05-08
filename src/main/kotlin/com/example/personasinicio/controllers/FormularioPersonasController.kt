package com.example.personasinicio.controllers

import com.example.personasinicio.mappers.toPersona
import com.example.personasinicio.models.PersonaDto
import com.example.personasinicio.repositories.PersonasRepository
import com.example.personasinicio.validators.validar
import com.github.michaelbull.result.getOrElse
import com.github.michaelbull.result.onSuccess
import javafx.fxml.FXML
import javafx.scene.control.Alert
import javafx.scene.control.Button
import javafx.scene.control.ProgressBar
import javafx.scene.control.TextField
import mu.KotlinLogging

private val logger = KotlinLogging.logger{}

class FormularioPersonasController() {

    @FXML
    private lateinit var nombreField: TextField

    @FXML
    private lateinit var edadField: TextField

    @FXML
    private lateinit var correoField: TextField

    @FXML
    private lateinit var botonBorrar: Button

    @FXML
    private lateinit var botonGuardar: Button

    @FXML
    private lateinit var botonVer: Button

    @FXML
    private lateinit var progressBar: ProgressBar

    private val repository = PersonasRepository()

    @FXML
    private fun initialize() {
        botonGuardar.isDisable = true
        botonBorrar.isDisable = true
        botonVer.isDisable = true
    }

    @FXML
    private fun onBorrarButtonClick() {
        logger.debug { "Controller -> Botón BORRAR" }
        nombreField.text = ""
        nombreField.style = "-fx-background-color: #EEC2FF;"
        edadField.text = ""
        edadField.style = "-fx-background-color: #EEC2FF;"
        correoField.text = ""
        correoField.style = "-fx-background-color: #EEC2FF;"
        comprobarCampos()
    }

    @FXML
    private fun onGuardarButtonClick() {
        logger.debug { "Controller -> Botón GUARDAR" }
        val persona = PersonaDto(
            nombreField.text,
            edadField.text,
            correoField.text
        )
        persona.validar().onSuccess {
            logger.info { "Controller -> Persona validada" }
            repository.guardar(persona.toPersona())
            Alert(Alert.AlertType.INFORMATION)
                .apply {
                    title = "Alerta de confirmación"
                    headerText = "Persona guardada con éxito"
                    contentText = "Nombre: ${nombreField.text}\n" +
                            "Edad: ${edadField.text}\n" +
                            "Correo: ${correoField.text}"
                }.showAndWait()
            onBorrarButtonClick()
        }.getOrElse { error ->
            logger.info { "Controller -> Persona no válida" }
            Alert(Alert.AlertType.ERROR)
                .apply {
                    title = "Alerta de error"
                    headerText = "Persona no válida"
                    contentText = error.message
                }.showAndWait()
        }
    }

    @FXML
    private fun onVerBotonClick() {

    }

    @FXML
    private fun onModificarNombre() {
        logger.debug { "Controller -> Nombre introducido: ${nombreField.text}" }
        val nombreRegex = Regex("^([a-zA-Z]+ *)+")
        if (nombreField.text == "") { nombreField.style = "-fx-background-color: #EEC2FF;" }
        else if (nombreField.text.matches(nombreRegex)) { nombreField.style = "-fx-background-color: #CCFFBC;" }
        else nombreField.style = "-fx-background-color: #FFBCBC;"
        comprobarCampos()
    }

    @FXML
    private fun onModificarEdad() {
        logger.debug { "Controller -> Edad introducida: ${edadField.text}" }
        val edadRegex = Regex("^\\d+$")
        if (edadField.text == "") { edadField.style = "-fx-background-color: #EEC2FF;" }
        else if (edadField.text.matches(edadRegex)) { edadField.style = "-fx-background-color: #CCFFBC;" }
        else edadField.style = "-fx-background-color: #FFBCBC;"
        comprobarCampos()
    }

    @FXML
    private fun onModificarCorreo() {
        logger.debug { "Controller -> Correo introducido: ${correoField.text}" }
        val correoRegex = Regex("^[\\w.]+@\\w+(.es|.com|.org)$")
        if (correoField.text == "") { correoField.style = "-fx-background-color: #EEC2FF;" }
        else if (correoField.text.matches(correoRegex)) { correoField.style = "-fx-background-color: #CCFFBC;" }
        else correoField.style = "-fx-background-color: #FFBCBC;"
        comprobarCampos()
    }

    @FXML
    private fun onRatonEncimaBorrar() {
        botonBorrar.style = "-fx-background-color: #FF4747;"
    }

    @FXML
    private fun onRatonQuitadoBorrar() {
        botonBorrar.style = "-fx-background-color: #FF9E9E;"
    }

    @FXML
    private fun onRatonEncimaGuardar() {
        botonGuardar.style = "-fx-background-color: #6FFF4B;"
    }

    @FXML
    private fun onRatonQuitadoGuardar() {
        botonGuardar.style = "-fx-background-color: #AAFF9E;"
    }

    @FXML
    private fun onRatonEncimaVer() {
        botonVer.style = "-fx-background-color: #62B8FF;"
    }

    @FXML
    private fun onRatonQuitadoVer() {
        botonVer.style = "-fx-background-color: #99D1FF;"
    }

    private fun comprobarCampos() {
        logger.debug { "Controller -> Comprobando si los campos son correctos" }
        var cont = 0
        if (nombreField.text != "") { cont++ }
        if (edadField.text != "") { cont++ }
        if (correoField.text != "") { cont++ }

        when (cont) {
            0 -> {
                progressBar.progress = 0.0
                botonGuardar.isDisable = true
                botonBorrar.isDisable = true
            }
            1 -> {
                progressBar.progress = 0.33
                botonGuardar.isDisable = true
                botonBorrar.isDisable = false
            }
            2 -> {
                progressBar.progress = 0.66
                botonGuardar.isDisable = true
                botonBorrar.isDisable = false
            }
            3 -> {
                progressBar.progress = 1.0
                botonGuardar.isDisable = false
                botonBorrar.isDisable = false
            }
        }
    }
}