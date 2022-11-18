package com.dh.clinica.service;

import com.dh.clinica.repository.GenericRepository;
import com.dh.clinica.model.Turno;

import java.util.List;

public class TurnoService {

    private GenericRepository<Turno> turnoRepository;

    public TurnoService(GenericRepository<Turno> turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    public Turno registrarTurno(Turno turno){
        return  turnoRepository.guardar(turno);
    }
    public List<Turno> listar(){
        return turnoRepository.buscarTodos();
    }


}
