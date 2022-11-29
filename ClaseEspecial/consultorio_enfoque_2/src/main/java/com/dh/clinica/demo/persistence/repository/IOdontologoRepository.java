package com.dh.clinica.demo.persistence.repository;

import com.dh.clinica.demo.persistence.entities.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IOdontologoRepository extends JpaRepository<Odontologo, Integer> {

    @Query("SELECT o FROM Odontologo o WHERE o.matricula=?1")
    Optional<Odontologo> buscar(Integer matricula);

    @Query("SELECT o FROM Odontologo o WHERE o.nombre=?1")
    Optional<List<Odontologo>> buscar(String nombre);

    @Query("SELECT o FROM Odontologo o WHERE o.nombre=?1 AND o.apellido=?2")
    Optional<List<Odontologo>> buscar(String nombre, String apellido);
}
