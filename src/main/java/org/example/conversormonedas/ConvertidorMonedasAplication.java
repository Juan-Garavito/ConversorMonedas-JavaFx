package org.example.conversormonedas;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import org.example.conversormonedas.Clases.*;

import java.io.IOException;
import java.net.URISyntaxException;

public class ConvertidorMonedasAplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ConvertidorMonedasAplication.class.getResource("convertidor_monedas.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 320);

        stage.setScene(scene);
        stage.setTitle("Conversor de Monedas");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}