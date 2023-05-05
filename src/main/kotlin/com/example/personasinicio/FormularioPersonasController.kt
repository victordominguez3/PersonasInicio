package com.example.personasinicio

import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextField

class FormularioPersonasController {
    @FXML
    private lateinit var welcomeText: Label

    @FXML
    private lateinit var nombreText: TextField

    @FXML
    private lateinit var edadText: TextField

    @FXML
    private lateinit var correoText: TextField

    @FXML
    private lateinit var botonBorrar: Button

    @FXML
    private lateinit var botonGuardar: Button

    @FXML
    private fun onBorrarButtonClick() {
        nombreText.text = ""
        edadText.text = ""
        correoText.text = ""
    }
}