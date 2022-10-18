package com.dh.liquidacionsueldo.main.model;

public class EmpleadoContratado extends Empleado {
    private int horasTrabajadas;
    private int valorHora;

    public EmpleadoContratado(String nombre, String apellido, String numeroDeCuenta) {
        super(nombre, apellido, numeroDeCuenta);
    }

    public EmpleadoContratado(String nombre, String apellido, String numeroDeCuenta, int horasTrabajadas, int valorHora) {
        super(nombre, apellido, numeroDeCuenta);
        this.horasTrabajadas = horasTrabajadas;
        this.valorHora = valorHora;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public int getValorHora() {
        return valorHora;
    }

    public void setValorHora(int valorHora) {
        this.valorHora = valorHora;
    }
}

