package org.example.conversormonedas.Peticiones;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ConvertidorJson {

    private static Gson gson =  new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public static Object convertirAObjeto(String texto, Class clase){
        Object object =  gson.fromJson(texto, clase);
        return  object;
    }

    public static String convertirAJson(Object object){
        return  gson.toJson(object);
    }
}