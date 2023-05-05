module com.example.personasinicio {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;


    opens com.example.personasinicio to javafx.fxml;
    exports com.example.personasinicio;
}