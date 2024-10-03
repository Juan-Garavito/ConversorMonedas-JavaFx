module org.example.conversormonedas {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.conversormonedas to javafx.fxml;
    exports org.example.conversormonedas;
}