package com.mx.efm.conversorMonedas.test;

import com.mx.efm.conversorMonedas.model.Cliente;
import com.mx.efm.conversorMonedas.model.ConversorMonedas;
import com.mx.efm.conversorMonedas.model.Moneda;
import com.mx.efm.conversorMonedas.model.MonedaAPI;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Moneda moneda = new Moneda("MXN","USD",254.00);
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        double monto = 0.0;
        boolean continuar = true;
        StringBuilder menu = new StringBuilder();
        menu.append("************************************************************\n");
        menu.append("Sea bienvenido/a al Conversor de Moneda =]\n");
        menu.append("1) Dólar =>> Peso argentino\n");
        menu.append("2) Peso argentino =>> Dólar\n");
        menu.append("3) Dólar =>> Real brasileño\n");
        menu.append("4) Real brasileño =>> Dólar\n");
        menu.append("5) Dólar =>> Peso colombiano\n");
        menu.append("6) Peso colombiano =>> Dólar\n");
        menu.append("7) Salir\n");
        menu.append("Elija una opción válida:\n");
        menu.append("************************************************************");
        String montoIngresa = "Ingrese el monto que desea convertir:\n";
//        System.out.println(menu.toString());
        Moneda moneda = new Moneda();
        ConversorMonedas conversor = new ConversorMonedas();
        Cliente cliente = new Cliente();
//        MonedaAPI monedaAPI = conversor.convierteMonedaImporte(cliente.EnviaPeticion(moneda));
//        moneda = new Moneda(monedaAPI);
//        System.out.println("moneda = " + moneda);

        while (continuar) {
            try {
                System.out.println(menu.toString());
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1, 2, 3, 4, 5, 6:
                        System.out.println(montoIngresa);
                        monto = sc.nextDouble();
                        moneda = switch (opcion) {
                            case 1 -> new Moneda("USD", "ARS", monto);
                            case 2 -> new Moneda("ARS", "USD", monto);
                            case 3 -> new Moneda("USD", "BRL", monto);
                            case 4 -> new Moneda("BRL", "USD", monto);
                            case 5 -> new Moneda("USD", "COP", monto);
                            case 6 -> new Moneda("COP", "USD", monto);
                            default -> null;
                        };
                        MonedaAPI monedaAPI = conversor.convierteMonedaImporte(cliente.EnviaPeticion(moneda));
                        moneda = new Moneda(monedaAPI);
                        System.out.println(String.format(
                                "✅ El valor de %.2f [%s] equivale a %.2f [%s].",
                                monto, moneda.getMonedaBase(), moneda.getConversionImporte(), moneda.getMonedaDestino()
                        ));
                        break;
                    case 7:
                        System.out.println("Hasta luego, vuelva pronto! \uD83C\uDF1F");
                        continuar = false; // Salimos del loop en vez de `return`
                        break;
                    default:
                        System.out.println("❌ ERROR: INGRESA UNA OPCIÓN VÁLIDA.");
                        break;
                }
            }catch (InputMismatchException e){
                System.out.println("❌ Error: Debes ingresar un número entero.");
                continuar = false;
            }catch (Exception e){
                System.out.println("🔍 Se ha producido un error general.");
                continuar = false;
            }

        }




    }
}
