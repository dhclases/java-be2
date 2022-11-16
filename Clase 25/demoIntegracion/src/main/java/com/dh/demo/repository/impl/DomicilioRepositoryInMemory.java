package com.dh.demo.repository.impl;

import com.dh.demo.model.Domicilio;
import com.dh.demo.repository.GenericRepository;

import java.util.ArrayList;
import java.util.List;

public class DomicilioRepositoryInMemory implements GenericRepository <Domicilio> {

    private List<Domicilio> domicilios;

    public DomicilioRepositoryInMemory() {
        this.domicilios = new ArrayList<>();

    }

    @Override
    public Domicilio guardar(Domicilio domicilio) {
        // JPA
        // JDBC
        // Inmemory
        domicilios.add(domicilio);
        return domicilio;
    }

    @Override
    public Domicilio buscar(Integer id) {
        for (Domicilio domicilio: domicilios){
            if (domicilio.getId() == id){
                return domicilio;
            }
        }
        return null;
    }

    @Override
    public void eliminar(Integer id) {
        for (Domicilio domicilio: domicilios){
            if (domicilio.getId() == id){
               domicilios.remove(domicilio);
               return;
            }
        }
    }

    @Override
    public List<Domicilio> buscarTodos() {
        return domicilios;
    }

    @Override
    public Domicilio actualizar(Domicilio domicilio) {
        eliminar(domicilio.getId());
        domicilios.add(domicilio);
        return domicilio;
    }
}
