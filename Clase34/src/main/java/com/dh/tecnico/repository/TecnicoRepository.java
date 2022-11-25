package com.dh.tecnico.repository;

import com.dh.tecnico.model.Jugador;
import com.dh.tecnico.model.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TecnicoRepository  extends JpaRepository<Tecnico, Long> {

    @Query("SELECT t FROM Tecnico t WHERE t.nombre = ?1 and t.edad = ?2")
    Optional<Tecnico> buscarTecnico(String nombre, int edad);

}

