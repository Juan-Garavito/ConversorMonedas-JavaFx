package org.example.conversormonedas.Clases;

import java.util.HashMap;
import java.util.List;

public class Codes {
    public HashMap<String, String> codes;

    public Codes(HashMap<String, String> codes) {
        this.codes = codes;
    }

    public HashMap<String, String> getCodes() {
        return codes;
    }

    public void setCodes(HashMap<String, String> codes) {
        this.codes = codes;
    }

    @Override
    public String toString() {
        return codes.toString();
    }
}
