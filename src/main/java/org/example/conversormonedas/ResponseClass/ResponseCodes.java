package org.example.conversormonedas.ResponseClass;

import java.util.List;

public record ResponseCodes(String result, List<List<String>> supported_codes) {

}
