package com.dh.tecnico.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Tecnico {

    @Id
    @SequenceGenerator(name = "tecnico_sequence", sequenceName = "tecnico_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tecnico_sequence")
    private Long id;

    private String nombre;

    private int edad;

    @OneToMany(mappedBy = "tecnico", fetch = FetchType.LAZY)
    private Set<Jugador> jugadores = new HashSet<>();




}
