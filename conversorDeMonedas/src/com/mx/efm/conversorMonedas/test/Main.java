package com.mx.efm.conversorMonedas.test;

import com.mx.efm.conversorMonedas.model.Cliente;
import com.mx.efm.conversorMonedas.model.ConversorMonedas;
import com.mx.efm.conversorMonedas.model.Moneda;
import com.mx.efm.conversorMonedas.model.MonedaAPI;

public class Main {
    public static void main(String[] args) {
        Moneda moneda = new Moneda("MXN","USD",254.00);
        ConversorMonedas conversor = new ConversorMonedas();
        Cliente cliente = new Cliente();
        MonedaAPI monedaAPI = conversor.convierteMonedaImporte(cliente.EnviaPeticion(moneda));
        moneda = new Moneda(monedaAPI);
        System.out.println("moneda = " + moneda);

    }
}
