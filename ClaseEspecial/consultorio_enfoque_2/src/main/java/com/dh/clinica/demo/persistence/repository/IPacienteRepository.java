package com.dh.clinica.demo.persistence.repository;

import com.dh.clinica.demo.persistence.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IPacienteRepository extends JpaRepository<Paciente, Integer> {

    @Query("SELECT p FROM Paciente p WHERE p.dni=?1")
    Optional<Paciente> buscar(Integer dni);

    @Query("SELECT p FROM Paciente p WHERE p.nombre=?1")
    Optional<List<Paciente>> buscar(String nombre);

    @Query("SELECT p FROM Paciente p WHERE p.nombre=?1 AND p.apellido=?2")
    Optional<List<Paciente>> buscar(String nombre, String apellido);

}
