package org.example.conversormonedas.Peticiones;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public  class Peticion {

    private static HttpClient client = HttpClient.newHttpClient();

    public static Object hacerPeticion(String url) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder().uri(new URI(url)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString()); // Enviar la petición y recibir respuesta
        return response.body();
    }
}
