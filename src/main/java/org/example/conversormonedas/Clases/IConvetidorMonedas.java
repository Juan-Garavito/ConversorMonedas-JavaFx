package org.example.conversormonedas.Clases;

public interface IConvetidorMonedas {

    Conversion convetirMoneda(String codeMoneda, String codeMonedaConvertida, float montoConvertir);
    Codes adquirirCodesMonedas();
}
