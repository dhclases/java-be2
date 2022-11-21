package com.dh.clinica.service;


import com.dh.clinica.repository.GenericRepository;
import com.dh.clinica.model.Paciente;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class PacienteService {

    private GenericRepository<Paciente> pacienteGenericRepository;

    public PacienteService(GenericRepository<Paciente> pacienteGenericRepository) {
        this.pacienteGenericRepository = pacienteGenericRepository;
    }

    public Paciente guardar(Paciente p) {
        p.setFechaIngreso(new Date());
        return pacienteGenericRepository.guardar(p);
    }

    public Optional<Paciente> buscar(Integer id) {
        return pacienteGenericRepository.buscar(id);
    }

    public List<Paciente> buscarTodos() {
        return pacienteGenericRepository.buscarTodos();
    }

    public void eliminar(Integer id) {
        pacienteGenericRepository.eliminar(id);
    }

    public Paciente actualizar(Paciente p) {
        return pacienteGenericRepository.actualizar(p);
    }
}
