package org.example.conversormonedas.Clases;

import java.util.ArrayList;
import java.util.List;

public class ListHistorial {

    private static List<Historial> historialList = new ArrayList<>();

    public void añadirHistorial(Historial historial){
        historialList.add(historial);
    }

    public List<Historial> getHistorialList(){
        return historialList;
    }
}
