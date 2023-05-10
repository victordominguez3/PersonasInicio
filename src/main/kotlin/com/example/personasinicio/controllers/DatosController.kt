package com.example.personasinicio.controllers

import com.example.personasinicio.FormularioPersonasApplication
import javafx.fxml.FXML
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.image.ImageView
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

class DatosController(datos: Array<String>) {

    @FXML
    private lateinit var campoNombre: Label

    @FXML
    private lateinit var campoEdad: Label

    @FXML
    private lateinit var campoCorreo: Label

    @FXML
    private lateinit var imagenBox: ImageView

    private val datos = datos
//    private val icono = FormularioPersonasApplication::class.java.getResource("")

    @FXML
    private fun initialize() {
        campoNombre.text = datos[0]
        campoEdad.text = datos[1] + " años"
        campoCorreo.text = datos[2]
//        imagenBox.image =
    }

}