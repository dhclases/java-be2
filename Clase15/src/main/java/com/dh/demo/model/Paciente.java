package com.dh.demo.model;

import java.time.LocalDate;

public class Paciente {
    private Integer id;
    private String nombres;
    private String apellidos;

    private Domicilio domicilio;

    private LocalDate fechaIngreso;

    public Paciente() {
        this.domicilio = new Domicilio();
    }

    public Paciente(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public Paciente(Integer id, String nombres, String apellidos, Integer cantidad, Double precio) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;

    }

    public Paciente(String nombres, String apellidos, Integer cantidad, Double precio) {
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
}
