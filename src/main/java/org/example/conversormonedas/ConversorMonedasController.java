package org.example.conversormonedas;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.conversormonedas.Clases.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class ConversorMonedasController {

    @FXML
    private ComboBox<String> select_codes_monedas;
    @FXML
    private ComboBox<String> convert_codes_monedas;
    @FXML
    private TextField cantidad_to_convert;
    @FXML
    private Text cantidad_convert;

    private ConvertidorMonedas convertidorMonedas = new ConvertidorMonedas();


    @FXML
    public void initialize() {
        Codes codes = convertidorMonedas.adquirirCodesMonedas();
        TreeMap<String, String> codesSorted = new TreeMap<>(codes.getCodes());
        List<String> keyCodes = new ArrayList<>(codesSorted.keySet());
        List<String> valuesCodes = new ArrayList<>(codesSorted.values());
        ObservableList<String> valoresComboBox = FXCollections.observableArrayList();

        for (int i = 0; i < keyCodes.size(); i++) {
            valoresComboBox.add(keyCodes.get(i) + " - " + valuesCodes.get(i));
        }

        select_codes_monedas.setItems(valoresComboBox);
        convert_codes_monedas.setItems(valoresComboBox);
        select_codes_monedas.setValue(valoresComboBox.get(0));
        convert_codes_monedas.setValue(valoresComboBox.get(1));

        //configurarComboBox(valoresComboBox, select_codes_monedas);
        //configurarComboBox(valoresComboBox, convert_codes_monedas);
    }


    @FXML
    public void convertirMonedas() {

        try {
            String selectMoneda = select_codes_monedas.getValue().substring(0, 3);
            String convertMoneda = convert_codes_monedas.getValue().substring(0, 3);
            Float cantidadToConvert = Float.valueOf(cantidad_to_convert.getText());
            Conversion conversion = convertidorMonedas.convetirMoneda(selectMoneda, convertMoneda, cantidadToConvert);
            cantidad_convert.setText(STR."El valor en \{convertMoneda} es --> \{conversion.getValorConversion()}");
            Historial historial = new Historial(LocalDate.now(), select_codes_monedas.getValue(), cantidadToConvert.floatValue(), convert_codes_monedas.getValue(), conversion.getValorConversion());
            añadirHistorial(historial);
        } catch (NumberFormatException e) {
            cantidad_convert.setText("Debes poner solo un valor numerico");
        } catch (Exception e) {
            System.out.println(e);
            cantidad_convert.setText("Ha ocurrido un error. Vuelvelo a intentar.");
        }

    }

    public void configurarComboBox(List<String> valoresComboBox, ComboBox<String> comboBox) {
        ObservableList<String> items = FXCollections.observableArrayList(valoresComboBox);
        comboBox.setItems(items);
        comboBox.setEditable(true);

        TextField comboBoxEditor = comboBox.getEditor();
        comboBoxEditor.textProperty().addListener((obs, oldValue, newValue) -> {

            System.out.println(obs);
            System.out.println(oldValue);
            System.out.println(newValue);
            ObservableList<String> filteredItems = FXCollections.observableArrayList();

            for (String item : items) {
                if (item.toLowerCase().contains(newValue.toLowerCase())) {
                    filteredItems.add(item);
                }
            }

            System.out.println(filteredItems.toString());
            if (filteredItems.isEmpty()) {
                comboBox.hide();
            } else {
                comboBox.setItems(filteredItems);
                comboBox.show();
            }

        });

    }

    public void añadirHistorial(Historial historial) {
        ListHistorial listHistorial = new ListHistorial();
        listHistorial.añadirHistorial(historial);
    }

    @FXML
    public void cambiarAEscena() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("historial.fxml"));

        Stage stage = (Stage) cantidad_convert.getParent().getScene().getWindow();
        Scene scene = new Scene(root, 700, 550);
        stage.setTitle("Historial");
        stage.setScene(scene);
        stage.show();

    }
}