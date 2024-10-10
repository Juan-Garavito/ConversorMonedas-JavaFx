package org.example.conversormonedas.Clases;

import java.time.LocalDate;

public class Historial {
    private LocalDate date;
    private String MonedaConvertir;
    private float valorConvertir;
    private String MonedaConvertida;
    private float valorConversion;

    public Historial(LocalDate date, String monedaConvertir, float valorConvertir, String monedaConvertida, float valorConversion) {
        this.date = date;
        MonedaConvertir = monedaConvertir;
        this.valorConvertir = valorConvertir;
        MonedaConvertida = monedaConvertida;
        this.valorConversion = valorConversion;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getMonedaConvertir() {
        return MonedaConvertir;
    }

    public float getValorConvertir() {
        return valorConvertir;
    }

    public String getMonedaConvertida() {
        return MonedaConvertida;
    }

    public float getValorConversion() {
        return valorConversion;
    }
}
