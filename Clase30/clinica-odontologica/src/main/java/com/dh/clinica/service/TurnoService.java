package com.dh.clinica.service;

import com.dh.clinica.repository.GenericRepository;
import com.dh.clinica.model.Turno;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
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
    public void eliminar(Integer id){
        turnoRepository.eliminar(id);
    }
    public Turno actualizar(Turno turno){
        return turnoRepository.actualizar(turno);
    }
    public Optional<Turno> buscar(Integer id){
        return turnoRepository.buscar(id);
    }

}
