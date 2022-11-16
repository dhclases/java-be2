package com.dh.demo.repository.impl;


import com.dh.demo.model.Paciente;
import com.dh.demo.repository.GenericRepository;

import java.util.ArrayList;
import java.util.List;

public class PacienteRepositoryInMemory implements GenericRepository<Paciente> {

    private List<Paciente> pacientes;

    public PacienteRepositoryInMemory() {
        this.pacientes = new ArrayList<>();

    }

    @Override
    public Paciente guardar(Paciente paciente) {
        // JPA
        // JDBC
        // Inmemory
        pacientes.add(paciente);
        return paciente;
    }

    @Override
    public Paciente buscar(Integer id) {
        for (Paciente paciente: pacientes){
            if (paciente.getId() == id){
                return paciente;
            }
        }
        return null;
    }

    @Override
    public void eliminar(Integer id) {
        for (Paciente paciente: pacientes){
            if (paciente.getId() == id){
                pacientes.remove(paciente);
                return;
            }
        }
    }

    @Override
    public List<Paciente> buscarTodos() {
        return pacientes;
    }

    @Override
    public Paciente actualizar(Paciente paciente) {
        eliminar(paciente.getId());
        pacientes.add(paciente);
        return paciente;
    }
}
