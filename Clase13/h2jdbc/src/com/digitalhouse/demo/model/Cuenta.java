package com.digitalhouse.demo.model;

public class Cuenta {
    private Long id;
    private int nruCuenta;
    private double saldo;
    private String nombre;

    public Cuenta(int nruCuenta, String nombre, double saldo) {
        this.nruCuenta = nruCuenta;
        this.saldo = saldo;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNruCuenta() {
        return nruCuenta;
    }

    public void setNruCuenta(int nruCuenta) {
        this.nruCuenta = nruCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
