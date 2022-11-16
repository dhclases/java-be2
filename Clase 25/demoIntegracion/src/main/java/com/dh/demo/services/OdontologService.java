package com.dh.demo.services;

import com.dh.demo.model.Odontologo;
import com.dh.demo.repository.GenericRepository;

import java.util.List;

public class OdontologService {
    private GenericRepository<Odontologo> odontologoRepository;

    public OdontologService(GenericRepository<Odontologo> odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    public Odontologo guardar(Odontologo odontologo){
        // TODO: Validaciones
        odontologoRepository.guardar(odontologo);
        return odontologo;
    }

    public Odontologo buscar (Integer id){
        return odontologoRepository.buscar(id);
    }

    public void eliminar(Integer id){
        // TODO: Validaciones
        odontologoRepository.eliminar(id);
    }

    public List<Odontologo> buscarTodos(){
        return odontologoRepository.buscarTodos();
    }

    public Odontologo actualizar( Odontologo odontologo){
        // TODO: Validaciones
        return odontologoRepository.actualizar(odontologo);
    }

}
