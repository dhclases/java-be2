package com.dh.demo.repository.impl;

import com.dh.demo.model.Odontologo;
import com.dh.demo.repository.GenericRepository;

import java.util.ArrayList;
import java.util.List;

public class OdontologRepositoryInMemory implements GenericRepository<Odontologo> {

    private List<Odontologo> odontologos;

    public OdontologRepositoryInMemory() {
        this.odontologos = new ArrayList<>();
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        odontologos.add(odontologo);
        return odontologo;
    }

    @Override
    public Odontologo buscar(Integer id) {
        for (Odontologo odontologo: odontologos){
            if (odontologo.getId() == id){
                return odontologo;
            }
        }
        return null;
    }

    @Override
    public void eliminar(Integer id) {
        for (Odontologo odontologo: odontologos){
            if (odontologo.getId() == id){
                odontologos.remove(odontologo);
                return;
            }
        }
    }

    @Override
    public List<Odontologo> buscarTodos() {
        return odontologos;
    }

    @Override
    public Odontologo actualizar(Odontologo odontologo) {
        eliminar(odontologo.getId());
        odontologos.add(odontologo);
        return odontologo;
    }
}
