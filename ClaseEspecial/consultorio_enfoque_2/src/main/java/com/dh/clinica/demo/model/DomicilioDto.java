package com.dh.clinica.demo.model;

import lombok.Data;

@Data
public class DomicilioDto {

    private Integer id;
    private String calle;
    private Integer numero;
    private String localidad;
    private String provincia;

    public DomicilioDto() { }

    public DomicilioDto(String calle, Integer numero, String localidad, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }
}
