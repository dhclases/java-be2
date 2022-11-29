package com.dh.clinica.demo.model;

import lombok.Data;

@Data
public class OdontologoDto {

    private Integer id;
    private Integer dni;
    private String nombre;
    private String apellido;
    private Integer matricula;

    public OdontologoDto() { }

    public OdontologoDto(Integer dni, String nombre, String apellido, Integer matricula) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }
}
