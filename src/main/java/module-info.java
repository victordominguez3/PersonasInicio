module com.example.personasinicio {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;
    requires kotlin.result.jvm;
    requires io.github.microutils.kotlinlogging;
    requires org.slf4j;


    opens com.example.personasinicio.controllers to javafx.fxml;
    exports com.example.personasinicio;
}