package com.example.personasinicio.routes

import com.example.personasinicio.FormularioPersonasApplication
import com.example.personasinicio.controllers.DatosController
import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.image.Image
import javafx.stage.Modality
import javafx.stage.Stage

object RoutesManager {
    private lateinit var mainStage: Stage
    private lateinit var _activeStage: Stage
    val activeStage get() = _activeStage
    lateinit var app: Application
    private val icono = Image(FormularioPersonasApplication::class.java.getResourceAsStream("icons/usuario.png"))

    fun initMainStage(stage: Stage) {
        val fxmlLoader = FXMLLoader(FormularioPersonasApplication::class.java.getResource("views/hello-view.fxml"))
        val scene = Scene(fxmlLoader.load(), 462.0, 259.0)
        stage.title = "Formulario Personas"
        stage.scene = scene
        stage.isResizable = false
        stage.icons.add(icono)
        mainStage = stage
        _activeStage = stage
        stage.show()
    }

    fun initDatosStage(datos: Array<String>) {
        val fxmlLoader = FXMLLoader(FormularioPersonasApplication::class.java.getResource("views/datos-view.fxml"))
        val controlador = DatosController(datos)
        fxmlLoader.setController(controlador)
        val scene = Scene(fxmlLoader.load(), 375.0, 210.0)
        val stage = Stage()
        stage.title = "Datos del formulario"
        stage.scene = scene
        stage.isResizable = false
        stage.initOwner(mainStage)
        stage.initModality(Modality.WINDOW_MODAL)
        stage.show()
    }
}