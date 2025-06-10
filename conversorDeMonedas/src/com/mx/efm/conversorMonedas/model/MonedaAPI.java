package com.mx.efm.conversorMonedas.model;

public record MonedaAPI(String baseCode,String targetCode, String conversionRate, String conversionResult) {
}
