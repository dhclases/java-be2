package com.dh.tecnico.repository;

import com.dh.tecnico.model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface JugadorRepository extends JpaRepository<Jugador, Long> {

    @Query("SELECT j FROM Jugador j where j.tecnico.nombre = ?1")
    Optional<Jugador> buscarJugador(String nombreTecnico);

}
