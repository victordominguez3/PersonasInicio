package com.example.personasinicio

import com.example.personasinicio.routes.RoutesManager.app
import com.example.personasinicio.routes.RoutesManager.initMainStage
import javafx.application.Application
import javafx.stage.Stage
import mu.KotlinLogging

private val logger = KotlinLogging.logger{}

class FormularioPersonasApplication : Application() {
    override fun start(stage: Stage) {
        logger.debug { "Application -> Start" }
        app = this@FormularioPersonasApplication
        initMainStage(stage)
    }
}

fun main() {
    Application.launch(FormularioPersonasApplication::class.java)
}