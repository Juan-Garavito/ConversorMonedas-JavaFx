package org.example.conversormonedas.Mappers;

import org.example.conversormonedas.Clases.Conversion;
import org.example.conversormonedas.ResponseClass.ResponseConversion;

public class MapperConversion {

    public static Conversion convertirResponseConversionAConversion(ResponseConversion responseConversion){
        return new Conversion(responseConversion.conversion_rate(), responseConversion.conversion_result());
    }
}
