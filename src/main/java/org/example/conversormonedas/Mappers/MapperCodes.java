package org.example.conversormonedas.Mappers;

import org.example.conversormonedas.Clases.Codes;
import org.example.conversormonedas.ResponseClass.ResponseCodes;

import java.util.HashMap;

public class MapperCodes {

    public static Codes convertirResponseCodesACodes(ResponseCodes responseCodes){
        HashMap<String, String> codes = new HashMap<>();

        responseCodes.supported_codes().forEach(code->{
            codes.put(code.get(0), code.get(1));
        });

        return new Codes(codes);
    }
}
