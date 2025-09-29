package model;

public class CuentaAhorros extends Cuenta {
    private boolean activa;

    public CuentaAhorros(float saldoInicial, float tasaAnual) {
        super(saldoInicial, tasaAnual);
        this.activa = saldoInicial >= 10000;
    }

    private void verificarActiva() {
        activa = saldo >= 10000;
    }

    @Override
    public void consignar(float cantidad) {
        if (activa) {
            super.consignar(cantidad);
        } else {
            System.out.println("La cuenta está inactiva, no se puede consignar.");
        }
    }

    @Override
    public void retirar(float cantidad) {
        if (activa) {
            super.retirar(cantidad);
        } else {
            System.out.println("La cuenta está inactiva, no se puede retirar.");
        }
    }

    @Override
    public void extractoMensual() {
        if (numRetiros > 4) {
            comisionMensual += (numRetiros - 4) * 1000;
        }
        super.extractoMensual();
        verificarActiva();
    }

    @Override
    public void imprimir() {
        System.out.println("------ Cuenta de Ahorros ------");
        System.out.println("Saldo: " + saldo);
        System.out.println("Comisión mensual: " + comisionMensual);
        System.out.println("Número de transacciones: " + (numConsignaciones + numRetiros));
        System.out.println("Estado de la cuenta: " + (activa ? "Activa" : "Inactiva"));
    }
}
