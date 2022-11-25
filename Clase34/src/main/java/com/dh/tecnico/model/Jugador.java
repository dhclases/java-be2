package com.dh.tecnico.model;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Jugador {

    @Id
    @SequenceGenerator(name = "jugador_sequence", sequenceName = "jugador_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jugador_sequence")
    private Long id;

    private String nombre;

    private String clubFavorito;

   @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="tecnico_id")
    private Tecnico tecnico;




}
