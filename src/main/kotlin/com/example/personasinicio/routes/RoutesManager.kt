package com.example.personasinicio.routes

import javafx.application.Application
import javafx.stage.Stage

object RoutesManager {
    private lateinit var mainStage: Stage
    private lateinit var _activeStage: Stage
    val activeStage get() = _activeStage
    lateinit var app: Application
}