package com.dh.demo.service;


import com.dh.demo.model.Paciente;
import com.dh.demo.repository.Repository;

public class PacienteService {

    private final Repository<Paciente> medicamentoRepo;

    // Se define para la injeccion del de la dependencia
    public PacienteService(Repository<Paciente> medicamentoRepo) {

        this.medicamentoRepo = medicamentoRepo;
    }
    // Se define los metodos del crud
    public Paciente guardar(Paciente paciente){
       return medicamentoRepo.guardar(paciente);

    }

    public Paciente buscar(Integer id){
        return medicamentoRepo.buscar(id);
    }
}
