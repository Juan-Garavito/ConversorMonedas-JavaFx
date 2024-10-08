package org.example.conversormonedas.Clases;

import org.example.conversormonedas.Mappers.MapperCodes;
import org.example.conversormonedas.Mappers.MapperConversion;
import org.example.conversormonedas.Peticiones.ConvertidorJson;
import org.example.conversormonedas.Peticiones.Peticion;
import org.example.conversormonedas.ResponseClass.ResponseCodes;
import org.example.conversormonedas.ResponseClass.ResponseConversion;

import java.io.IOException;
import java.net.URISyntaxException;

public class ConvertidorMonedas  implements IConvetidorMonedas{

    public  ConvertidorMonedas(){

    }

    @Override
    public Conversion convetirMoneda(String codeMoneda, String codeMonedaConvertida, float montoConvertir) {
        final String BASE_URL = System.getenv().get("BASE_URL");
        final String API_KEY = System.getenv().get("API_KEY");
        String url = STR."\{BASE_URL}/\{API_KEY}/pair/\{codeMoneda}/\{codeMonedaConvertida}/\{montoConvertir}";

        Object object;
        Conversion conversion;

        try {
            object = Peticion.hacerPeticion(url);
            ResponseConversion responseConversion = (ResponseConversion) ConvertidorJson.convertirAObjeto(object.toString(), ResponseConversion.class);
            conversion = MapperConversion.convertirResponseConversionAConversion(responseConversion);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return conversion;
    }

    @Override
    public Codes adquirirCodesMonedas() {
        final String BASE_URL = System.getenv().get("BASE_URL");
        final String API_KEY = System.getenv().get("API_KEY");
        String url = BASE_URL+"/"+API_KEY+"/codes";
        Object object;
        try {
             object = Peticion.hacerPeticion(url);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        ResponseCodes responseCodes = (ResponseCodes) ConvertidorJson.convertirAObjeto(object.toString(), ResponseCodes.class);
        Codes codes = MapperCodes.convertirResponseCodesACodes(responseCodes);
        return codes;
    }
}
