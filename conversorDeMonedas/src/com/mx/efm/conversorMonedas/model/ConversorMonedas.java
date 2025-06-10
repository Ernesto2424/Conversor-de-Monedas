package com.mx.efm.conversorMonedas.model;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ConversorMonedas {


    public MonedaAPI convierteMonedaImporte(String peticion){
        Gson gson = new GsonBuilder()
     //           .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setPrettyPrinting()
                .create();
        MonedaAPI monedaAPI = gson.fromJson(peticion, MonedaAPI.class);
        System.out.println(monedaAPI);
        return monedaAPI;
    }
}
