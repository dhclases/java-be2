package com.dh.demo.service;

import com.dh.demo.model.Medicamento;
import com.dh.demo.repository.Repository;

public class MedicamentoService {

    private final Repository<Medicamento> medicamentoDao;

    // Se define para la injeccion del de la dependencia
    public MedicamentoService(Repository<Medicamento> medicamentoDao) {

        this.medicamentoDao = medicamentoDao;
    }
    // Se define los metodos del crud
    public Medicamento guardar(Medicamento medicamento){
       return medicamentoDao.guardar(medicamento);

    }

    public  Medicamento buscar(Integer id){
        return medicamentoDao.buscar(id);
    }
}
