package com.dh.demo.services;

import com.dh.demo.model.Domicilio;
import com.dh.demo.repository.GenericRepository;

import java.util.List;

public class DomicilioService {
    private GenericRepository<Domicilio> domicilioRepository;

    public DomicilioService(GenericRepository<Domicilio> domicilioRepository) {
        this.domicilioRepository = domicilioRepository;
    }

    Domicilio guardar( Domicilio domicilio){
        // TODO: Validaciones
        domicilioRepository.guardar(domicilio);
        return domicilio;
    }

    Domicilio buscar (Integer id){
       return domicilioRepository.buscar(id);
    }

    void eliminar(Integer id){
        // TODO: Validaciones
        domicilioRepository.eliminar(id);
    }

    List<Domicilio> buscarTodos(){
        return domicilioRepository.buscarTodos();
    }

    Domicilio actualizar( Domicilio domicilio){
        // TODO: Validaciones
        return domicilioRepository.actualizar(domicilio);
    }
}
