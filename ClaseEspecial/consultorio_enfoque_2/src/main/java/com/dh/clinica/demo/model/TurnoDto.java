package com.dh.clinica.demo.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TurnoDto {

    private Integer id;
    private LocalDateTime fecha;
    private PacienteDto paciente;
    private OdontologoDto odontologo;

    public TurnoDto() { }

    public TurnoDto(LocalDateTime fecha, PacienteDto paciente, OdontologoDto odontologo) {
        this.fecha = fecha;
        this.paciente = paciente;
        this.odontologo = odontologo;
    }
}
