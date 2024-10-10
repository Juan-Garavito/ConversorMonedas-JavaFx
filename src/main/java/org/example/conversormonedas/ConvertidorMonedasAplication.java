package org.example.conversormonedas;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class ConvertidorMonedasAplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ConvertidorMonedasAplication.class.getResource("convertidor_monedas.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 550);

        stage.setScene(scene);
        stage.setTitle("Conversor de Monedas");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}