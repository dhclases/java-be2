package com.dh.clinica.demo.persistence.entities.auth;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name="roles")
@Getter
@NoArgsConstructor
@Entity
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rol_seq")
    @SequenceGenerator(name = "rol_seq", sequenceName = "rol_seq", allocationSize = 1)
    @Column
    private Long id;

    @Setter
    @Column
    private String name;

    public Rol(String name) {
        this.name = name;
    }
}
