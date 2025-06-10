package com.mx.efm.conversorMonedas.model;

public class Moneda {

    private String monedaBase;
    private String monedaDestino;
    private double importe;
    private double conversionImporte;

    public Moneda(){}

    public Moneda(MonedaAPI monedaAPI){
        this.monedaBase = monedaAPI.baseCode();
        this.monedaDestino = monedaAPI.targetCode();
        this.importe = Double.parseDouble(monedaAPI.conversionRate());
        this.conversionImporte = Double.parseDouble(monedaAPI.conversionResult());
    }

    public Moneda(String monedaBase, String monedaDestino, double importe){
        this.monedaBase = monedaBase;
        this.monedaDestino = monedaDestino;
        this.importe = importe;
        this.conversionImporte = conversionImporte;
    }

    public String getMonedaBase() {
        return monedaBase;
    }

    public void setMonedaBase(String monedaBase) {
        this.monedaBase = monedaBase;
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    public void setMonedaDestino(String monedaDestino) {
        this.monedaDestino = monedaDestino;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public double getConversionImporte() {
        return conversionImporte;
    }

    public void setConversionImporte(double conversionImporte) {
        this.conversionImporte = conversionImporte;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Moneda{");
        sb.append("monedaBase='").append(monedaBase).append('\'');
        sb.append(", monedaDestino='").append(monedaDestino).append('\'');
        sb.append(", importe=").append(importe);
        sb.append(", conversionImporte=").append(conversionImporte);
        sb.append('}');
        return sb.toString();
    }
}
