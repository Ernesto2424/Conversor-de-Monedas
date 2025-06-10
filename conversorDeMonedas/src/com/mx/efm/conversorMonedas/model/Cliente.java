package com.mx.efm.conversorMonedas.model;

import java.io.IOException;
import java.net.URI;
import java.net.http.*;
public class Cliente {
    public  static final String API_KEY = "2a47fbdfc7ca4531505a9c16";
    String url;

    public Cliente(){}

    public Cliente(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String EnviaPeticion(Moneda moneda) {
        String json = null;
        try {
            this.setUrl("https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/"
                    + moneda.getMonedaBase() + "/" + moneda.getMonedaDestino() + "/" + moneda.getImporte());
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            json = response.body();
        //    System.out.println(json);
        } catch (IOException | InterruptedException e) {
            System.out.println("Ha ocurrido un error");
        }

        return json;

    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Cliente{");
        sb.append("url='").append(url).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
