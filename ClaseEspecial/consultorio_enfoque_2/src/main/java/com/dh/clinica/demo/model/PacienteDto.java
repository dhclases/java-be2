package com.dh.clinica.demo.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PacienteDto {

    private Integer id;
    private String nombre;
    private String apellido;
    private Integer dni;
    private LocalDate fechaIngreso;
    private DomicilioDto domicilio;

    public PacienteDto() { }

    public PacienteDto(String nombre, String apellido, Integer dni, DomicilioDto domicilio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.domicilio = domicilio;
    }

    public PacienteDto(String nombre, String apellido, Integer dni, LocalDate fechaIngreso, DomicilioDto domicilio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
    }
}
