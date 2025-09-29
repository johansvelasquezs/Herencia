package model;

public class Cuenta {

    protected float saldo;
    protected int numConsignaciones;
    protected int numRetiros;
    protected float tasaAnual;
    protected float comisionMensual;

    public Cuenta(float saldoInicial, float tasaAnual) {
        this.saldo = saldoInicial;
        this.tasaAnual = tasaAnual;
        this.numConsignaciones = 0;
        this.numRetiros = 0;
        this.comisionMensual = 0;
    }

    public void consignar(float cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            numConsignaciones++;
        }
    }

    public void retirar(float cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad;
            numRetiros++;
        } else {
            System.out.println("No es posible retirar: saldo insuficiente.");
        }
    }

    public void calcularInteresMensual() {
        float interesMensual = (saldo * (tasaAnual / 100)) / 12;
        saldo += interesMensual;
    }

    public void extractoMensual() {
        saldo -= comisionMensual;
        calcularInteresMensual();
    }

    public void imprimir() {
        System.out.println("Saldo: " + saldo);
        System.out.println("Consignaciones: " + numConsignaciones);
        System.out.println("Retiros: " + numRetiros);
        System.out.println("Tasa anual: " + tasaAnual + "%");
        System.out.println("Comisión mensual: " + comisionMensual);
    }
}