package org.example.conversormonedas;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import org.example.conversormonedas.Clases.Historial;
import org.example.conversormonedas.Clases.ListHistorial;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HistorialController {

    @FXML
    private TableView<Historial> tablaHistorial;

    @FXML
    private TableColumn<Historial, LocalDate> columnaFecha;

    @FXML
    private TableColumn<Historial, String> columnaMonedaConvertir;

    @FXML
    private TableColumn<Historial, Float> columnaValorConvertir;

    @FXML
    private TableColumn<Historial, String> columnaMonedaConvertida;

    @FXML
    private TableColumn<Historial, Float> columnaValorConversion;


    @FXML
    public void initialize() {
        columnaFecha.setCellValueFactory(new PropertyValueFactory<>("date"));
        columnaMonedaConvertir.setCellValueFactory(new PropertyValueFactory<>("monedaConvertir"));
        columnaValorConvertir.setCellValueFactory(new PropertyValueFactory<>("valorConvertir"));
        columnaMonedaConvertida.setCellValueFactory(new PropertyValueFactory<>("monedaConvertida"));
        columnaValorConversion.setCellValueFactory(new PropertyValueFactory<>("valorConversion"));

        tablaHistorial.setItems(obtenerHistorial());
    }

    private ObservableList<Historial> obtenerHistorial() {
        ObservableList<Historial> historialList = FXCollections.observableArrayList();
        ListHistorial listHistorial = new ListHistorial();
        for(Historial historial : listHistorial.getHistorialList()){
            historialList.add(historial);
        }
        return historialList;
    }

    @FXML
    public void cambiarAEscena() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("convertidor_monedas.fxml"));
        Stage stage = (Stage) tablaHistorial.getParent().getScene().getWindow();
        Scene scene = new Scene(root, 700, 550);
        stage.setTitle("Conversor de Monedas");
        stage.setScene(scene);
        stage.show();
    }

}

