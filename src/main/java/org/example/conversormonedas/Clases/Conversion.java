package org.example.conversormonedas.Clases;

public class Conversion {
    float valorUnitario;
    float valorConversion;

    public Conversion(float valorUnitario, float valorConversion) {
        this.valorUnitario = valorUnitario;
        this.valorConversion = valorConversion;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public float getValorConversion() {
        return valorConversion;
    }

    public void setValorConversion(float valorConversion) {
        this.valorConversion = valorConversion;
    }

    @Override
    public String toString() {
        return "{" +
                "valorUnitario=" + valorUnitario +
                ", valorConversion=" + valorConversion +
                '}';
    }
}
