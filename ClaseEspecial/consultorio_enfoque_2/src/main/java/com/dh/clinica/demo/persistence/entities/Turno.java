package com.dh.clinica.demo.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Entity
@Table(name = "turnos")
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turno_seq")
    @SequenceGenerator(name = "turno_seq", sequenceName = "turno_seq", allocationSize = 1)
    @Column(name = "turno_id")
    private Integer id;

    @Setter
    @Column
    private LocalDateTime fecha;

    @Setter
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @Setter
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "odontologo_id", nullable = false)
    private Odontologo odontologo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Turno turno = (Turno) o;
        return Objects.equals(id, turno.id) && Objects.equals(fecha, turno.fecha) && Objects.equals(paciente, turno.paciente) && Objects.equals(odontologo, turno.odontologo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fecha, paciente, odontologo);
    }
}
