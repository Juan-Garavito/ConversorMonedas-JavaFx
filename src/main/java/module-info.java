module org.example.conversormonedas {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.google.gson;


    opens org.example.conversormonedas to javafx.fxml;
    exports org.example.conversormonedas;
    exports org.example.conversormonedas.Clases;
    opens org.example.conversormonedas.Clases to javafx.fxml;
    exports org.example.conversormonedas.Mappers;
    opens org.example.conversormonedas.Mappers to javafx.fxml;
    exports org.example.conversormonedas.Peticiones;
    opens org.example.conversormonedas.Peticiones to javafx.fxml;
    exports org.example.conversormonedas.ResponseClass;
    opens org.example.conversormonedas.ResponseClass to javafx.fxml;
}