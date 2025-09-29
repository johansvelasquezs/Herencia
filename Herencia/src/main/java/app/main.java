package app;

import model.CuentaAhorros;

public class main {
    public static void main(String[] args) {

        CuentaAhorros ahorro = new CuentaAhorros(12000, 12);


        ahorro.consignar(2000);
        ahorro.retirar(1500);
        ahorro.retirar(3000);
        ahorro.retirar(2000);
        ahorro.retirar(1000);
        ahorro.extractoMensual();


        ahorro.imprimir();
    }
}