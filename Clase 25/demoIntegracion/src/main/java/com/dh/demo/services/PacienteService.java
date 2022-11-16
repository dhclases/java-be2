package com.dh.demo.services;

import com.dh.demo.model.Paciente;

import com.dh.demo.repository.GenericRepository;
import org.springframework.stereotype.Service;


import java.util.List;


public class PacienteService {
    private GenericRepository<Paciente> pacienteRepository;

    public PacienteService(GenericRepository<Paciente> pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente guardar( Paciente paciente){
        // TODO: Validaciones
        pacienteRepository.guardar(paciente);
        return paciente;
    }

    public Paciente buscar (Integer id){
        return pacienteRepository.buscar(id);
    }

    public void eliminar(Integer id){
        // TODO: Validaciones
        pacienteRepository.eliminar(id);
    }

    public List<Paciente> buscarTodos(){
        return pacienteRepository.buscarTodos();
    }

    public Paciente actualizar( Paciente paciente){
        // TODO: Validaciones
        return pacienteRepository.actualizar(paciente);
    }

}
