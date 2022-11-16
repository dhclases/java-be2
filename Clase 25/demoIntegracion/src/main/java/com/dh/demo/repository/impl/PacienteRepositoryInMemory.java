package com.dh.demo.repository.impl;


import com.dh.demo.model.Paciente;
import com.dh.demo.repository.GenericRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PacienteRepositoryInMemory implements GenericRepository<Paciente> {

    private List<Paciente> pacientes;

    public PacienteRepositoryInMemory() {
        this.pacientes = new ArrayList<>();
        Paciente p = new Paciente();
        p.setId(1);
        p.setEmail("a@a.com");
        p.setNombre("mi nombre");
        p.getDomicilio().setCalle("mi caller");
        p.getDomicilio().setNumero(1212);
        p.getDomicilio().setId(2);
        p.setFechaIngreso(LocalDate.of(2022,12,10));
        pacientes.add(p);

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
