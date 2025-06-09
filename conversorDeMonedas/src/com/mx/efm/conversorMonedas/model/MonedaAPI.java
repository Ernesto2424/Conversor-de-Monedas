package com.mx.efm.conversorMonedas.model;

public record MonedaAPI(String base_code,String target_code, String conversion_rate, String conversion_result) {
}
