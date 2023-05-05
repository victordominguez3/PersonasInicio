package com.example.personasinicio

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage

class FormularioPersonasApplication : Application() {
    override fun start(stage: Stage) {
        val fxmlLoader = FXMLLoader(FormularioPersonasApplication::class.java.getResource("hello-view.fxml"))
        val scene = Scene(fxmlLoader.load(), 462.0, 259.0)
        stage.title = "Formulario Personas"
        stage.scene = scene
        stage.isResizable = false
        stage.show()
    }
}

fun main() {
    Application.launch(FormularioPersonasApplication::class.java)
}