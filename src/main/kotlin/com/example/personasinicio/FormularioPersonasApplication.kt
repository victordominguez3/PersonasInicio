package com.example.personasinicio

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage
import mu.KotlinLogging

private val logger = KotlinLogging.logger{}

class FormularioPersonasApplication : Application() {
    override fun start(stage: Stage) {
        logger.debug { "Application -> Start" }
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