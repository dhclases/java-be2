package com.dh.profesor.service;

import com.dh.profesor.model.Profesor;
import com.dh.profesor.repository.ProfesorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfesorService {

    private final ProfesorRepository profesorRepository;

    public ProfesorService(ProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }

    public Optional<Profesor> guardar(Profesor profesor){
        return  Optional.of(profesorRepository.save(profesor));
    }
}
